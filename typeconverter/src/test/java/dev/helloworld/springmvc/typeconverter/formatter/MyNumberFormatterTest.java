package dev.helloworld.springmvc.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {

        Number result = formatter.parse("1,000", Locale.KOREA);
        assertEquals(1000l, result);
    }

    @Test
    void print() {
        String print = formatter.print(1000, Locale.KOREA);
        assertEquals("1,000", print);

    }
}