package com.example.proxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class PojoAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AFTER foo() ADVICE");
    }
}
