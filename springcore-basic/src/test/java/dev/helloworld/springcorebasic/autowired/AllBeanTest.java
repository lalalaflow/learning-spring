package dev.helloworld.springcorebasic.autowired;

import dev.helloworld.springcorebasic.AutoAppConfig;
import dev.helloworld.springcorebasic.discount.DiscountPolicy;
import dev.helloworld.springcorebasic.member.Grade;
import dev.helloworld.springcorebasic.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertInstanceOf(DiscountService.class, discountService);
        Assertions.assertEquals(1000, discountPrice);

        int rateDiscountPolicy = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertEquals(2000, rateDiscountPolicy);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
