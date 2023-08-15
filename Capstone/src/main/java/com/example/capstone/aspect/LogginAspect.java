package com.example.capstone.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j

public class LogginAspect {
    @Before("execution(* com..example.capstone.controller.HomeController.*(..))")
    public void testAOP(){
        System.out.println("AOP TEST");
        log.info("hello");
    }
}
