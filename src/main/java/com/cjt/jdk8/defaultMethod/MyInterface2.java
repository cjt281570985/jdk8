package com.cjt.jdk8.defaultMethod;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface MyInterface2 {
    default void myDefaultMethod(){
        System.out.println("myDefaultMethod2");
    }
}
