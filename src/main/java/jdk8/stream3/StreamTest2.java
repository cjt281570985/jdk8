package jdk8.stream3;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

    //流的一些基本操作
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "world", "qq");
        String[] arr = stream.toArray(length -> new String[length]);
        Arrays.asList(arr).stream().forEach(System.out::println);

        //stream 不能重复使用
        System.out.println("------------");
        String[] stringArr = Stream.of("hello", "world", "qq").toArray(String[]::new);
        Arrays.asList(stringArr).stream().forEach(System.out::println);

        //为何使用Optional<String>
        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
        Optional<String> first = stringStream.findFirst();
        first.ifPresent(System.out::println);

        //流的短路 findFirst
        List<String> list = Arrays.asList("hello", "world56753扔", "cjt21321");
        list.stream().mapToInt(item ->
                {
                    int length =  item.length();
                    System.out.println("test.....");
                    return  length;
                }

        ).filter(length->length>5).findFirst().ifPresent(System.out::println);

        //对第一个参数(种子) 进行迭代, 无限串行流
        Stream.iterate(2, x->x+2).limit(5).forEach(System.out::println);
        System.out.println("------------");
        //skip去掉前几个
        Stream.iterate(2, x->x+2).limit(5).skip(2).mapToInt(value -> value+1).forEach(System.out::println);
        System.out.println("-----------------");

        OptionalInt max = Stream.iterate(2, x -> x + 2).limit(5).skip(2).mapToInt(value -> value + 1).max();
        System.out.println(max.getAsInt());

        //OptionalInt.empty
        OptionalInt max2 = Stream.iterate(2, x -> x + 2).limit(5).filter(val->val>20).skip(2).mapToInt(value -> value + 1).max();
        System.out.println(max2);

        //迭代函数
        IntStream.iterate(1, x->x*3).limit(5).forEach(System.out::println);
        IntSummaryStatistics intSummaryStatistics = IntStream.iterate(1, x -> x * 3).limit(5).summaryStatistics();
        //IntSummaryStatistics{count=5, sum=121, min=1, average=24.200000, max=81}
        System.out.println(intSummaryStatistics);

        //distinct
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,1,3);
        list2.stream().distinct().forEach(System.out::println);

        List<String> listString = Arrays.asList("hello5", "world", "cjt");
        listString.stream().map(item->{
            String result = item.substring(0,1).toUpperCase()+item.substring(1);
            System.out.println("this is map invoke.....");
            return result;
        }).filter(a->a.length()>5).forEach(System.out::println);

        //---------------还有调试代码---------------------------------------------
        //peek
        List<Integer> list5 = Arrays.asList(1,2,3,4,5,6,1,3);
        list5.stream().map(val->2*val).filter(val->val%3==0).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("sum is:"+list5.stream().filter(num -> num != null).distinct().
                mapToInt(num -> num*2).peek(System.out::println).skip(2).limit(3).sum());

    }
}
