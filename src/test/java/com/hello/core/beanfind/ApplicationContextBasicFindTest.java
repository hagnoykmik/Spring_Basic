package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.hello.core.beanfind fileName       : ApplicationContextBasicFindTest author
 *        : SSAFY date           : 2023-02-24 description    : ===========================================================
 * DATE              AUTHOR             NOTE -----------------------------------------------------------
 * 2023-02-24        SSAFY       최초 생성
 */
public class ApplicationContextBasicFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


  @Test
  @DisplayName("빈이름으로 조회")
  public void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
//    System.out.println("memberService = " + memberService);
//    System.out.println("memberService.getClass() = " + memberService.getClass());
    // 검증
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("이름없이 타입으로만 조회")
  public void findBeanByType() {
    MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  public void findBeanByName2() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
}
