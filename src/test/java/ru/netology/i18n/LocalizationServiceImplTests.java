package ru.netology.i18n;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalizationServiceImplTests {

    @Test
    @DisplayName("Проверка возвращаемого текста - Русский")
    public void testRu() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        assertThat(localizationService.locale(Country.RUSSIA), is("Добро пожаловать"));
    }

    @Test
    @DisplayName("Проверка возвращаемого текста - Английский")
    public void testEn() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        assertThat(localizationService.locale(Country.USA), is("Welcome"));
    }
}
