package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest2 {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(new int[]{3,5,7});
        intStream.forEach(System.out::println);
        System.out.println("-------------");
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("-------------");
        IntStream.rangeClosed(3,8).forEach(System.out::println);

        System.out.println("-------------");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().map(val->2*val).reduce(3, Integer::sum));
        list.stream().map(val->2*val).reduce(Integer::sum).ifPresent(System.out::println);
    }
}
