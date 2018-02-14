package org.training.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class TransliterationServiceImplTest {
    private TransliterationService service;

    @Before
    public void setUp() {
        service = new TransliterationServiceImpl();
    }

    @Test
    @Parameters(method = "getNames")
    public void givenUkrainianWhenTransliterationServiceCalledShouldReturnEnglish(
            String ukrainianName, String englishName) {
        Map<String, String> converted = service.convertUkrainianToEnglish(ukrainianName);
        assertTrue(converted.containsKey(ukrainianName));
        assertEquals(englishName, converted.get(ukrainianName));
    }

    private static final Object[] getNames() {
        return new Object[] {
                new Object[] {"Петро", "Petro"},
                new Object[] {"Сідоренко", "Sidorenko"},
                new Object[] {"Тетяна", "Tetiana"},
                new Object[] {"Фоміцька", "Fomitska"},
                new Object[] {"Віктор123Андрієнко.", "Viktor123Andriienko."}
        };
    }

}
