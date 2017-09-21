package com.cjt.jdk8.defaultMethod;

/**
 * Created by Administrator on 2017/1/15.
 */
public class MyClass1 implements MyInterface1, MyInterface2 {
    @Override
    public void myDefaultMethod() {
        MyInterface2.super.myDefaultMethod();
        System.out.println("MyClass1");
    }

    public static void main(String[] args) {
        MyClass1 myClass1 = new MyClass1();
        myClass1.myDefaultMethod();
    }
}
