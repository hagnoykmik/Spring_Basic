package com.hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(lifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class lifeCycleConfig {

        @Bean // 호출된 결과물이 스프링 빈으로 등록
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();  // 스프링 빈에 등록할 때 생성자 호출
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
