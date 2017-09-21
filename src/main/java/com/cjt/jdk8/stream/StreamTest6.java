package com.cjt.jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest6 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello5", "world", "cjt");
        list.stream().map(item->{
            String result = item.substring(0,1).toUpperCase()+item.substring(1);
            System.out.println("this is map invoke.....");
            return result;
        }).filter(a->a.length()>5).forEach(System.out::println);

        System.out.println("---------------");
        //distinct().limit(6) 执行不结束
        Stream.iterate(1, item->item%3).distinct().limit(6).forEach(System.out::println);

    }
}
