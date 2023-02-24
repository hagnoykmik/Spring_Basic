package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.hello.core.beanfind fileName       : ApplicationContextInfoTest author
 *   : SSAFY date           : 2023-02-23 description    : ===========================================================
 * DATE              AUTHOR             NOTE -----------------------------------------------------------
 * 2023-02-23        SSAFY       최초 생성
 */
public class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  // bean들이 잘 등록되었는지 확인

  @Test
  @DisplayName("모든 빈 출력하기")
  public void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();  // ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회
    for (String beanDefinitionName : beanDefinitionNames) {      // iter
      Object bean = ac.getBean(                                  // ac.getBean : 빈이름으로 빈객체(인스턴스)를 조회
          beanDefinitionName);                                   // bean을 꺼낸다 (type지정안해줘서 object로 꺼내진다)
      System.out.println("name = " + beanDefinitionName + " object = " + bean);
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  public void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(
          beanDefinitionName);      // ac.getBeanDefinition : bean 하나하나에 대한 메타데이터 정보들을 반환 -> 코드에서는 스프링이 내부에서 사용하는 빈을 getRole()로 구분하기 위해 사용

      // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
      // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈

      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {  // 내가 등록한 빈
        Object bean = ac.getBean(beanDefinitionName);
        System.out.println("name = " + beanDefinitionName + " object = " + bean);
      }
    }
  }
}
