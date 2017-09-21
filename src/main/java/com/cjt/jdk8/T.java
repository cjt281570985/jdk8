package com.cjt.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/3/31.
 */
public class T {

    public static void main(String[] args) {

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,3,5), Arrays.asList(2,3), Arrays.asList(4,5,6));
        stream.flatMap(ls->ls.stream()).map(x->x*x).distinct().forEach(System.out::println);

        List<String> list1 = Arrays.asList("hello", "你好", "HI");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");

        list1.stream().flatMap(a->list2.stream().map(b->a+" "+b)).forEach(System.out::println);



    }

}
