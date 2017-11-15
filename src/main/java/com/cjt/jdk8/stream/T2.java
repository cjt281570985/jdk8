package com.cjt.jdk8.stream;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/9.
 */
public class T2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,2,3,4,5,6,7,8);
        intStream.average().ifPresent(System.out::println);

        IntPredicate predicate = value -> value>5;
        System.out.println(intStream.anyMatch(predicate));
        intStream.filter(predicate).forEach(System.out::println);
        intStream.filter(predicate).findFirst().ifPresent(System.out::println);
        intStream.filter(predicate).min().ifPresent(System.out::println);
        IntStream.range(3,6).forEach(System.out::println);

        System.out.println("-------iterate--------");

        Stream.iterate(1, a->a+2).limit(6).forEach(System.out::println);

        System.out.println("result: "+
                Stream.iterate(1, a->a+2).limit(6).filter(a->a>2).mapToInt(a->a*2).skip(2).limit(2).summaryStatistics());

    }
}
