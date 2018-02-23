package com.macgregor.ef.resource;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestJavaTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource())
            .build();

    @Test
    public void simpleResourceTest() throws Exception {
        assertThat(resources.target("/hello-world").request().get(String.class))
                .isEqualTo("Hello world macgregor");
    }
}
