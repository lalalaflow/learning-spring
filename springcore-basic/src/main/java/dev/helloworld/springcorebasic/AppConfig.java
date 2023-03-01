package dev.helloworld.springcorebasic;

import dev.helloworld.springcorebasic.discount.DiscountPolicy;
import dev.helloworld.springcorebasic.discount.FixDiscountPolicy;
import dev.helloworld.springcorebasic.discount.RateDiscountPolicy;
import dev.helloworld.springcorebasic.member.MemberRepository;
import dev.helloworld.springcorebasic.member.MemberService;
import dev.helloworld.springcorebasic.member.MemberServiceImpl;
import dev.helloworld.springcorebasic.member.MemoryMemberRepository;
import dev.helloworld.springcorebasic.order.OrderService;
import dev.helloworld.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
