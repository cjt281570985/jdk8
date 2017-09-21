package com.cjt.jdk8.stream3;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> ls = Arrays.asList("yzy" ,"cjt", "jimmy");
        ls.stream().peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(a -> a + "_cjt")
        .forEach(System.out::println);

    }
}
