package dev.helloworld.springmvc.messagestart.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void helloMessage() {
        String result = messageSource.getMessage("hello", null, null);
        Assertions.assertEquals("hello", result);

    }

    @Test
    void notFoundMessageCode() {
        Assertions.assertThrows(NoSuchMessageException.class, () -> messageSource.getMessage("no_code", null, null));
    }

    @Test
    void notFoundMessageCodeDefaultMessage() {

        Assertions.assertEquals("기본 메시지", messageSource.getMessage("no_code", null, "기본 메시지", null));
    }

    @Test
    void argumentMessage() {
        String message = messageSource.getMessage("hello.name", new Object[]{"Spring"}, null);
        Assertions.assertEquals("hello Spring", message);
    }

    @Test
    void defaultLang() {
        Assertions.assertEquals("hello", messageSource.getMessage("hello", null, null));
        Assertions.assertEquals("hello", messageSource.getMessage("hello", null, Locale.ENGLISH));
    }

    @Test
    void koLang() {
        Assertions.assertEquals("안녕", messageSource.getMessage("hello", null, Locale.KOREA));
    }
}
