package ru.netology.geo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeoServiceImplTests {

    @Test
    @DisplayName("Проверка определения локации по ip - Русский")
    public void testRu() {
        GeoService geoService = new GeoServiceImpl();
        assertThat(geoService.byIp("172.0.0.0").getCountry(), is(Country.RUSSIA));
        assertThat(geoService.byIp("96.0.0.0").getCountry(), is(Country.USA));
    }
    @Test
    @DisplayName("Проверка определения локации по ip - Английский")
    public void testEn() {
        GeoService geoService = new GeoServiceImpl();
        assertThat(geoService.byIp("172.0.0.0").getCountry(), is(Country.RUSSIA));
        assertThat(geoService.byIp("96.0.0.0").getCountry(), is(Country.USA));
    }
}





