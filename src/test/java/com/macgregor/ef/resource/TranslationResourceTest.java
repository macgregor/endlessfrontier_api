package com.macgregor.ef.resource;

import com.macgregor.ef.dao.TranslationDAO;
import com.macgregor.ef.exceptions.PageinationExceptionMapper;
import com.macgregor.ef.model.canonical.Translation;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TranslationResourceTest extends ResourceTest {
    private static final TranslationDAO translationDAO = mock(TranslationDAO.class);

    @ClassRule
    public static final ResourceTestRule resources =ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new TranslationResource(translationDAO))
            .addProvider(PageinationExceptionMapper.class)
            .build();

    public TranslationResourceTest(){
        super(resources, TranslationResource.BASE_URI, "translation");
    }

    @After
    public void tearDown() {
        reset(translationDAO);
    }

    @Before
    public void setUp(){
        List<Translation> translations = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Translation t = new Translation();
            t.setId(Integer.toString(i));
            t.setValue(String.format("%s%d", entityName, i));
            translations.add(t);
        }

        when(translationDAO.getAll()).thenReturn(translations);
        when(translationDAO.findById("1")).thenReturn(translations.get(1));
        when(translationDAO.count()).thenReturn(translations.size());
        when(translationDAO.page(any(), any())).thenReturn(translations.subList(0,10));
    }

    @Test
    public void testFindAllUnits() throws Exception {
        List<Translation> result = resources.target(baseURI).request().get(new GenericType<List<Translation>>() {});

        assertEquals(10, result.size());
        assertEquals(String.format("%s%d", entityName, 0), result.get(0).getValue());
    }

    @Test
    public void testFindUnitById() throws Exception {
        Translation translation = resources.target(baseURI + "/1").request().get(Translation.class);
        assertThat(translation.getId()).isEqualTo("1");
        assertThat(translation.getValue()).isEqualTo(String.format("%s%d", entityName, 1));
    }
}
