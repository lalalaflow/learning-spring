package dev.helloworld.springmvc.typeconverter.converter;

import dev.helloworld.springmvc.typeconverter.type.IpPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        Assertions.assertEquals(10, result);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        Assertions.assertEquals("10", result);
    }

    @Test
    void ipPortToString() {
        IpPortToStringConverter ipPortToStringConverter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = ipPortToStringConverter.convert(source);
        Assertions.assertEquals("127.0.0.1:8080", result);
    }

    @Test
    void stringToIpPort() {
        StringToIpPortConverter stringToIpPortConverter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = stringToIpPortConverter.convert(source);
        Assertions.assertEquals(new IpPort("127.0.0.1", 8080), result);
    }

}