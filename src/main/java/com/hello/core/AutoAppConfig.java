package com.hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  // @Component가 붙은 class를 자동으로 스프링 빈으로 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 뺄꺼(AppConfig)
)

public class AutoAppConfig {


}
