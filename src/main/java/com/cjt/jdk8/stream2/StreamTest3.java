package com.cjt.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/3/29
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("111", "555", "hello word","211","asdf32");

        Stream<String> stream = list.stream();

        System.out.println("-------------111111111111---------------");

        Stream<String> stream1 = stream.map(item -> item + "___666");

        System.out.println("-------------222222222222---------------");

        stream1.forEach(System.out::println);

//        System.out.println("***************11111111****************");
//
//        list.stream().forEach(System.out::println);
//
//        System.out.println("***************22222222****************");
//
//        list.forEach(System.out::println);


    }

}
