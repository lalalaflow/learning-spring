package dev.helloworld.springcorebasic.order;

import dev.helloworld.springcorebasic.AppConfig;
import dev.helloworld.springcorebasic.member.Grade;
import dev.helloworld.springcorebasic.member.Member;
import dev.helloworld.springcorebasic.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}