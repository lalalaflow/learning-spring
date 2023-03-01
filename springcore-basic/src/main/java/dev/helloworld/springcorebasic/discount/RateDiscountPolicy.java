package dev.helloworld.springcorebasic.discount;

import dev.helloworld.springcorebasic.annotation.MainDiscountPolicy;
import dev.helloworld.springcorebasic.member.Grade;
import dev.helloworld.springcorebasic.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
