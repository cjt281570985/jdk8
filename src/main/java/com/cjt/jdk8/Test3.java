package com.cjt.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Administrator on 2016/12/30.
 */
public class Test3 {

    public static void main(String[] args) {
        MyInterface1 interface1 = ()->{};
        MyInterface2 interface2 = ()->{};

        System.out.println(interface1.getClass().getInterfaces()[0]);
        System.out.println(interface2.getClass().getInterfaces()[0]);

        new Thread(()->{System.out.println("hello world!");}).start();

        List<String> list = Arrays.asList("chenjt", "lin");
        list.stream().map(item ->item.toUpperCase()).forEach(val -> System.out.print(val+" "));
        list.stream().map(String::toUpperCase).forEach(val -> System.out.print(val+" "));
        System.out.println();
        System.out.println();
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

    }

    @FunctionalInterface
    interface MyInterface1 {
        void test1();

        public  String toString();
    }

    @FunctionalInterface
    interface MyInterface2 {
        void test2();

        public  String toString();
    }
}
