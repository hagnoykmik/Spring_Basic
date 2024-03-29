package com.hello.core.order;
// 클라이언트

import com.hello.core.annotation.MainDiscountPolicy;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;                                   // 인터클래스(추상클래스)에만 의존
    private final DiscountPolicy discountPolicy;                                       // 인터클래스(추상클래스)에만 의존

    // 생성자를 통해서 어떤 구현 객체가 주입될지는 알 수 없다
// lombok으로 대체(@RequiredArgsConstructor)
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);              // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);   // 할인정책에 회원 넘기기
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
