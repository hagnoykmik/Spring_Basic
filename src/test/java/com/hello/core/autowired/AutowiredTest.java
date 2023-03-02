package com.hello.core.autowired;

import com.hello.core.member.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutowiredTest {

  @Test
  void AutowiredOption() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }

  // 임의의 스프링 빈
  static class TestBean {
    @Autowired(required = false)              // noBean1이 호출안됨 -> 의존관계가 없으면 메서드 자체가 호출안됨
    public void setNoBean1(Member noBean1) {  // Member는 스프링이 관리하는 빈 X
      System.out.println("noBean1 = " + noBean1);
    }

    @Autowired
    public void setNoBean2(@Nullable Member noBean2) {  // 호출은 되지만 null로 들어온다.
      System.out.println("noBean2 = " + noBean2);
    }

    @Autowired
    public void setNoBean3(Optional<Member> noBean3) {  // 스프링 빈이 없으면 Optional.empty로 나온다.
      System.out.println("noBean3 = " + noBean3);
    }

  }
}
