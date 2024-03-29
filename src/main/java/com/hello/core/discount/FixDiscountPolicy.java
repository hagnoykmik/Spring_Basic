package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;  // 1000원 할인

   @Override
    public int discount(Member member, int price) {
       // Enum 타입은 == 쓰는게 맞다
       if (member.getGrade() == Grade.VIP) {
           return discountFixAmount;
       } else {
           return 0;
       }
    }
}
