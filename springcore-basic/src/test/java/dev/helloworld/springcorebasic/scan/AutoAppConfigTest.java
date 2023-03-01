package dev.helloworld.springcorebasic.scan;

import dev.helloworld.springcorebasic.AutoAppConfig;
import dev.helloworld.springcorebasic.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberService.class, memberService);
    }
}
