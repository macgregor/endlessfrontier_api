package com.macgregor.ef;

import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import com.macgregor.ef.dao.*;
import com.macgregor.ef.health.EndlessFrontierAPIHealthCheck;
import com.macgregor.ef.model.Unit;
import com.macgregor.ef.resource.*;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jetty.NonblockingServletHolder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class EndlessFrontierAPI extends Application<EndlessFrontierAPIConfiguration> {


    public static void main(String[] args) throws Exception {
        new EndlessFrontierAPI().run(args);
    }

    private final HibernateBundle<EndlessFrontierAPIConfiguration> hibernate = new HibernateBundle<EndlessFrontierAPIConfiguration>(Unit.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(EndlessFrontierAPIConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

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

        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(EndlessFrontierAPIConfiguration configuration, Environment environment) throws Exception {

        final UnitDAO unitDAO = new UnitDAO(hibernate.getSessionFactory());
        final UnitResource unitResource = new UnitResource(unitDAO);
        environment.jersey().register(unitResource);

        final TribeDAO tribeDAO = new TribeDAO(hibernate.getSessionFactory());
        final TribeResource tribeResource = new TribeResource(tribeDAO);
        environment.jersey().register(tribeResource);

        final PetDAO petDAO = new PetDAO(hibernate.getSessionFactory());
        final PetResource petResource = new PetResource(petDAO);
        environment.jersey().register(petResource);

        final PetSkillDAO petSkillDAO = new PetSkillDAO(hibernate.getSessionFactory());
        final PetSkillResource petSkillResource = new PetSkillResource(petSkillDAO);
        environment.jersey().register(petSkillResource);

        final ArtifactDAO artifactDAO = new ArtifactDAO(hibernate.getSessionFactory());
        final ArtifactResource artifactResource = new ArtifactResource(artifactDAO);
        environment.jersey().register(artifactResource);

        final ArtifactSetDAO artifactSetDAO = new ArtifactSetDAO(hibernate.getSessionFactory());
        final ArtifactSetResource artifactSetResource = new ArtifactSetResource(artifactSetDAO);
        environment.jersey().register(artifactSetResource);

        final UnitSkillDAO unitSkillDAO = new UnitSkillDAO(hibernate.getSessionFactory());
        final UnitSkillResource unitSkillResource = new UnitSkillResource(unitSkillDAO);
        environment.jersey().register(unitSkillResource);

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
