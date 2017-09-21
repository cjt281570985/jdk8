package com.cjt.jdk8.predicate;

import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/1/6.
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length()>5;
        System.out.println(predicate.test("hello 2"));

    }


}
