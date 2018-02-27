package com.macgregor.ef;

import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import com.macgregor.ef.dao.UnitDAO;
import com.macgregor.ef.health.RestJavaHealthCheck;
import com.macgregor.ef.model.Unit;
import com.macgregor.ef.resource.UnitResource;
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

public class RestJava extends Application<RestJavaConfiguration> {


    public static void main(String[] args) throws Exception {
        new RestJava().run(args);
    }

    private final HibernateBundle<RestJavaConfiguration> hibernate = new HibernateBundle<RestJavaConfiguration>(Unit.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(RestJavaConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<RestJavaConfiguration> bootstrap) {
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

        bootstrap.addBundle(new SwaggerBundle<RestJavaConfiguration>() {

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RestJavaConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });

        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(RestJavaConfiguration configuration, Environment environment) throws Exception {

        final UnitDAO unitDAO = new UnitDAO(hibernate.getSessionFactory());
        final UnitResource unitResource = new UnitResource(unitDAO);
        environment.jersey().register(unitResource);

        //set up healthchecks
        environment.healthChecks().register("rest java healthcheck", new RestJavaHealthCheck());

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
