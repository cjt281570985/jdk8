package jdk8.stream;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/9.
 */
public class T3 {
    public static void main(String[] args) throws Exception {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,1,3);
        list.stream().map(val->2*val).filter(val->val%3==0).reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("sum is:"+list.stream().filter(num -> num != null).distinct().
                mapToInt(num -> num*2).peek(System.out::println).skip(2).limit(3).sum());

        Stream<String> stream22 = Stream.of("bbb", "a232", "xxx", "nnn");
        stream22.map(String::toUpperCase).forEach(System.out::println);

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,3,5), Arrays.asList(2,3), Arrays.asList(4,5,6));
        stream.flatMap(list1 -> list1.stream()).distinct().forEach(System.out::println);

        String param = "iphone7 plus 256G";
        String a = URLEncoder.encode(param,"UTF-8");
        System.out.println(a);
        System.out.println("-------3333-------");

        List<String> list3 = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");
        list3.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        Stream<String> stream6 = Stream.of("bbb", "a232", "xxx", "nnn");
        System.out.println(stream6.collect(Collectors.joining()));

        System.out.println("----------拆分字符串, 并去重----------");
        //拆分字符串, 并去重
        List<String> list6 = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");
         list6.stream().map(ss->ss.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


    }
}
