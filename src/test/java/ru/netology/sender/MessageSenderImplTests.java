package ru.netology.sender;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageSenderImplTests {

    @Test
    @DisplayName("Проверка языка отправляемого сообщения - Английский")
    public void testEn() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(geoService.byIp("1.1.1.1")).thenReturn(new Location("test", Country.USA, "test", 1));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("English");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "1.1.1.1");
        assertThat(messageSender.send(headers), is("English"));
    }

    @Test
    @DisplayName("Проверка языка отправляемого сообщения - Русский")
    public void testRu() {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(geoService.byIp("1.1.1.1")).thenReturn(new Location("test", Country.RUSSIA, "test", 1));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Russian");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "1.1.1.1");
        assertThat(messageSender.send(headers), is("Russian"));

    }

}
