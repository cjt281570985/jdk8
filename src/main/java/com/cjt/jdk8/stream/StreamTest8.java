package com.cjt.jdk8.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest8 {

    public static void main(String[] args) {
        //流的短路
        List<String> list = Arrays.asList("hello", "world56753扔", "cjt21321");
        list.stream().mapToInt(item ->
                {
                    int length =  item.length();
                    System.out.println("test.....");
                    return  length;
                }

        ).filter(length->length>5).findFirst().ifPresent(System.out::println);
    }
}
