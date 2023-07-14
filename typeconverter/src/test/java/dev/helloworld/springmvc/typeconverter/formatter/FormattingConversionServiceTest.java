package dev.helloworld.springmvc.typeconverter.formatter;

import dev.helloworld.springmvc.typeconverter.converter.IpPortToStringConverter;
import dev.helloworld.springmvc.typeconverter.converter.StringToIpPortConverter;
import dev.helloworld.springmvc.typeconverter.type.IpPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.junit.jupiter.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //포매터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertEquals(new IpPort("127.0.0.1", 8080), ipPort);

        //포매너 사용
        assertEquals("1,000", conversionService.convert(1000l, String.class));
        assertEquals(1000l, conversionService.convert("1,000", Long.class));
    }
}
