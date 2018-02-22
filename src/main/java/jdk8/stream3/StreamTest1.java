package jdk8.stream3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {

        //stream 的各种定义形式
        Stream stream1 = Stream.of("yzy","abc","lhq");

        String[] arr = {"aaa", "bbb", "ccc"};
        List list = Arrays.asList(arr);

        Stream stream2 = Stream.of(arr);
        Stream stream3 = list.stream();

        int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5}).sum();
        System.out.println(sum);

        Arrays.stream(new int[]{1, 2, 3, 4, 5}).forEach(System.out::println);

        System.out.println("--------------");
        IntStream intStream = IntStream.of(5,6,7);
        intStream.forEach(System.out::println);

        System.out.println("-------------");
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("-------------");
        IntStream.rangeClosed(3,8).forEach(System.out::println);

        System.out.println("-------------");
        List<Integer> ls = Arrays.asList(1,2,3);

        //有默认值和无默认区别说明
        Integer reduce = ls.stream().map(val -> val * 2).reduce(0, (integer, integer2) -> integer+integer2);
        System.out.println(reduce);

        //(a,b)->a+b   Integer::sum
        ls.stream().reduce(Integer::sum).ifPresent(System.out::println);

    }
}
