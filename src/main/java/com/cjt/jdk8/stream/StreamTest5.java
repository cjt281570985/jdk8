package com.cjt.jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest5 {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
        stringStream.findFirst().ifPresent(System.out::println);

        //对第一个参数(种子) 进行迭代, 无限串行流
        Stream.iterate(1, item->item+2).limit(6).forEach(System.out::println);

        System.out.println("---------------");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().map(val->2*val).reduce(0, Integer::sum));

        System.out.println(Stream.iterate(1, item->item+2).limit(6).filter(val->val>2).mapToInt(val->2*val).skip(2).limit(2).reduce(0, Integer::sum));;
        System.out.println(Stream.iterate(1, item->item+2).limit(6).filter(val->val>2).mapToInt(val->2*val).skip(2).limit(2).sum());

        //OptionalInt.empty
        System.out.println(Stream.iterate(1, item->item+2).limit(6).filter(val->val>200).mapToInt(val->2*val).skip(2).limit(2).max());

        //IntSummaryStatistics{count=0, sum=0, min=2147483647, average=0.000000, max=-2147483648}
        System.out.println(Stream.iterate(1, item->item+2).limit(6).filter(val->val>200).mapToInt(val->2*val).skip(2).limit(2).summaryStatistics());

        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,1,3);
        list2.stream().distinct().forEach(System.out::println);
    }
}
