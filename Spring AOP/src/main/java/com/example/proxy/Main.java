package com.example.proxy;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        Pojo pojo = new SimplePojo();
        // this is a direct method call on the 'pojo' reference
        pojo.foo();

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new PojoAdvice());

        Pojo pojo2 = (Pojo) factory.getProxy();
        // this is a method call on the JDK Dynamic proxy!
        pojo2.foo();

    }
}
