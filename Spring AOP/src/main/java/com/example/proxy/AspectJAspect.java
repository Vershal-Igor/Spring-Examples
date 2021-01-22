package com.example.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJAspect {

    @Before("execution(* com.example.proxy.SimplePojo.foo(..))")
    public void beforeFooAdvice(JoinPoint joinPoint) {
        System.out.println("AspectJ before " + joinPoint.getSignature().getName() + " advice...");
    }
}
