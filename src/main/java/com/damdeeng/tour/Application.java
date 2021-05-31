package com.damdeeng.tour;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;


@Slf4j
// @EnableAutoConfiguration + @ComponentScan + @Configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

    // 최상위 패키지의 애플리케이션 클래스 위치
    // 애플리케이션 컴포넌트 자동 빈(Bean) 등록 (Component, Service, Repository, Controller ... etc)
    @PostConstruct
    public void setUp() {
        log.info("Log level : INFO");
        log.debug("Log level : DEBUG");
        log.warn("Log level : WARN");
        log.error("Log level : ERROR");
        log.trace("Log level : TRACE");
    }

    public static void main(String[] args) {

        // 특정 라이브러리에 적용되지 않는 경우
//        System.setProperty("spring.devtools.restart.enabled", "false");

        // spring singleton object
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        SpringApplication.run(Application.class, args);

    }

}
