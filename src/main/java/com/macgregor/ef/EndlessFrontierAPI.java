package com.macgregor.ef;

import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import com.macgregor.ef.dao.*;
import com.macgregor.ef.dataload.EndlessFrontierDataLoader;
import com.macgregor.ef.dataload.XmlPOJOExtractor;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.health.EndlessFrontierAPIHealthCheck;
import com.macgregor.ef.model.*;
import com.macgregor.ef.resource.*;
import io.dropwizard.Application;
import io.dropwizard.bundles.redirect.PathRedirect;
import io.dropwizard.bundles.redirect.RedirectBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jetty.NonblockingServletHolder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndlessFrontierAPI extends Application<EndlessFrontierAPIConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(EndlessFrontierAPI.class);


    public static void main(String[] args) throws Exception {
        new EndlessFrontierAPI().run(args);
    }

    private final HibernateBundle<EndlessFrontierAPIConfiguration> hibernate = new HibernateBundle<EndlessFrontierAPIConfiguration>(
            Unit.class,
            UnitSkill.class,
            Artifact.class,
            ArtifactSet.class,
            Pet.class,
            PetSkill.class,
            Tribe.class,
            Translation.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(EndlessFrontierAPIConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    private final XmlPOJOExtractor extractor = new XmlPOJOExtractor();

    @Override
    public void initialize(Bootstrap<EndlessFrontierAPIConfiguration> bootstrap) {
        /*
         * Enable variable substitution with environment variables
         *
         * https://stackoverflow.com/questions/23464451/overriding-server-connector-config-with-env-variables-with-dropwizard/23898581
         * put environment variable inside ${}
         * use :- operator to provide default value
         * example - port: ${PORT:-8080}
         */
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new SwaggerBundle<EndlessFrontierAPIConfiguration>() {

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(EndlessFrontierAPIConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });

        bootstrap.addBundle(new RedirectBundle(
                new PathRedirect("/", "/swagger")
        ));

        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(EndlessFrontierAPIConfiguration configuration, Environment environment) throws Exception {
        SessionFactory sessionFactory = hibernate.getSessionFactory();

        //load xml data into h2 database
        EndlessFrontierDataLoader dataLoader = new EndlessFrontierDataLoader(sessionFactory);
        dataLoader.loadAll();

        //register all resources
        environment.jersey().register(new UnitResource(new UnitDAO(sessionFactory)));
        environment.jersey().register(new TribeResource(new TribeDAO(sessionFactory)));
        environment.jersey().register(new PetResource(new PetDAO(sessionFactory)));
        environment.jersey().register(new PetSkillResource(new PetSkillDAO(sessionFactory)));
        environment.jersey().register(new ArtifactResource(new ArtifactDAO(sessionFactory)));
        environment.jersey().register(new ArtifactSetResource(new ArtifactSetDAO(sessionFactory)));
        environment.jersey().register(new UnitSkillResource(new UnitSkillDAO(sessionFactory)));
        environment.jersey().register(new TranslationResource(new TranslationDAO(sessionFactory)));

        //register custom exception mappers
        environment.jersey().register(new PageinationExceptionMapper());

        //set up healthchecks
        environment.healthChecks().register("ef healthcheck", new EndlessFrontierAPIHealthCheck());

        //set up metrics-servlet admin endpoints
        environment.getApplicationContext().setAttribute(
                MetricsServlet.METRICS_REGISTRY,
                environment.metrics());
        environment.getApplicationContext().setAttribute(
                HealthCheckServlet.HEALTH_CHECK_REGISTRY,
                environment.healthChecks());
        environment.getApplicationContext().addServlet(
                new NonblockingServletHolder(new AdminServlet()), "/admin/*");
    }
}
