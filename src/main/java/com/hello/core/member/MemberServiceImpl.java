package com.hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 생성자를 통해 memberRepository의 구현체가 뭐가들어갈지 선택
    public MemberServiceImpl(MemberRepository memberRepository) { // memoryMemberRepository가 할당됨

        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
