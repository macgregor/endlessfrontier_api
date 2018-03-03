package com.macgregor.ef.resource;

import com.macgregor.ef.dao.TranslationDAO;
import com.macgregor.ef.model.Translation;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TranslationResourceTest {
    private static final TranslationDAO translationDAO = mock(TranslationDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new TranslationResource(translationDAO))
            .build();

    @After
    public void tearDown() {
        reset(translationDAO);
    }

    @Test
    public void testFindAllTranslations() throws Exception {
        List<Translation> translations = new ArrayList<>();
        Translation t1 = new Translation();
        t1.setId("1");
        t1.setValue("translation1");
        translations.add(t1);

        Translation t2 = new Translation();
        t2.setId("2");
        t2.setValue("translation2");
        translations.add(t2);

        when(translationDAO.getAll()).thenReturn(translations);

        List<Translation> result = resources.target("/translation").request().get(new GenericType<List<Translation>>() {});

        assertEquals(2, result.size());
        assertEquals("translation1", result.get(0).getValue());
    }

    @Test
    public void testFindTranslationById() throws Exception {
        Translation t1 = new Translation();
        t1.setId("1");
        t1.setValue("translation1");
        when(translationDAO.findById("1")).thenReturn(t1);

        Translation unit = resources.target("/translation/1").request().get(Translation.class);
        assertThat(unit.getId()).isEqualTo("1");
        assertThat(unit.getValue()).isEqualTo("translation1");
    }
}
