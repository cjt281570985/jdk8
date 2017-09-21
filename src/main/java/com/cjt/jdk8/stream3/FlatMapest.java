package com.cjt.jdk8.stream3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapest {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hello", "你好", "HI");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");

        //flatmap 把多个流  统一成一个流, 此处不能用map
        list1.stream().flatMap(a-> list2.stream().map(b->a+" " +b)).forEach(System.out::println);

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2,3), Arrays.asList(4,5,6));
        //stream.flatMap(list2 -> list2.stream()).map(x->x*x).forEach(System.out::println);
        stream.flatMap(list -> list.stream()).forEach(System.out::println);

        System.out.println("-----------");
        Stream<List<Integer>> stream3 = Stream.of(Arrays.asList(1,3,5), Arrays.asList(2,3), Arrays.asList(4,5,6));
        stream3.flatMap(list->list.stream()).distinct().forEach(System.out::println);

        System.out.println("-----------");
        //拆分字符串, 并去重
        List<String> list = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");

        List<String[]> strings = list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList());
        strings.forEach(arr->Arrays.stream(arr).forEach(System.out::println));

        System.out.println("--------------------");
//        Stream<String[]> stream = list.stream().map(item -> item.split(" "));
//        stream.flatMap(Arrays::stream).distinct().forEach(System.out::println);
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

    }
}
