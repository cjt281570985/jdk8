package com.cjt.jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest10 {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("hello", "你好", "HI");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");

        //flatmap 把多个流  统一成一个流, 此处不能用map
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);


    }
}
