package dev.helloworld.springcorebasic.beanfind;

import dev.helloworld.springcorebasic.AppConfig;
import dev.helloworld.springcorebasic.member.MemberService;
import dev.helloworld.springcorebasic.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("스프링 빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("이름없이 구체 타입으로만 조회")
    void findBeanByType2() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {

        Assertions.assertThrows(NoSuchBeanDefinitionException.class
                , () -> ac.getBean("xxxxxx", MemberService.class));
    }
}
