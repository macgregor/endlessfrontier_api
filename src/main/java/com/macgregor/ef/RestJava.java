package com.macgregor.ef;

import com.macgregor.ef.health.RestJavaHealthCheck;
import com.macgregor.ef.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class RestJava extends Application<RestJavaConfiguration> {


    public static void main(String[] args) throws Exception {
        new RestJava().run(args);
    }

    @Override
    public void initialize(Bootstrap<RestJavaConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<RestJavaConfiguration>() {

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RestJavaConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(RestJavaConfiguration configuration, Environment environment) throws Exception {
        registerResources(environment);
        registerHealthChecks(environment);
    }

    private void registerResources(Environment environment) {
        environment.jersey().register(HelloWorldResource.class);
    }

    private void registerHealthChecks(Environment environment) {
        environment.healthChecks().register("restjava", new RestJavaHealthCheck());
    }
}
