package dev.helloworld.springcorebasic.discount;


import dev.helloworld.springcorebasic.member.Member;

public interface DiscountPolicy {

    /**
     * @param member
     * @param pirce
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
