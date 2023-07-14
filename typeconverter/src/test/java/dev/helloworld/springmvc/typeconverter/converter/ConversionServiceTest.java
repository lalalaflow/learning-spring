package dev.helloworld.springmvc.typeconverter.converter;

import dev.helloworld.springmvc.typeconverter.type.IpPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.junit.jupiter.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        // register
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());

        //use
        Integer result = conversionService.convert("10", Integer.class);
        assertEquals(10, result);
        assertEquals("10", conversionService.convert(10, String.class));

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertEquals(new IpPort("127.0.0.1", 8080), ipPort);

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertEquals("127.0.0.1:8080", ipPortString);
    }
}
