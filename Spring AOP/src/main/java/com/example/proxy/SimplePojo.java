package com.example.proxy;

public class SimplePojo implements Pojo {

    @Override
    public void foo() {
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
    }

    public void bar() {
        System.out.println("some logic...");
    }
}
