package com.example.proxy;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        Pojo pojo = new SimplePojo();
        // this is a direct method call on the 'pojo' reference
        System.out.println("Target object call:");
        pojo.foo();
        System.out.print("\n");

        //Spring AOP - JDK Dynamic proxy example
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new PojoAdvice());

        Pojo pojoProxy = (Pojo) factory.getProxy();
        // this is a method call on the JDK Dynamic proxy!
        System.out.println("Spring AOP proxy object call");
        pojoProxy.foo();

        //AspectJ - JDK Dynamic proxy example
        // create a factory that can generate a proxy for the given target object
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(pojo);
        aspectJProxyFactory.addAspect(AspectJAspect.class);

        // now get the proxy object...
        Pojo proxy = aspectJProxyFactory.getProxy();
        System.out.println("AspectJ proxy object call");
        proxy.foo();
    }
}
