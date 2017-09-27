package stream;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest4flatMap {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hell2o", "world", "q2q", "99");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream().map(x->x*x).forEach(System.out::println);

        System.out.println("----------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2,3), Arrays.asList(4,5,6));
        //stream.flatMap(list2 -> list2.stream()).map(x->x*x).forEach(System.out::println);
        stream.flatMap(list2 -> list2.stream()).map(a->a-1).forEach(System.out::println);

        System.out.println("-----------");
        Stream<List<Integer>> stream3 = Stream.of(Arrays.asList(1,3,5), Arrays.asList(2,3), Arrays.asList(4,5,6));
        stream3.flatMap(list5->list5.stream()).distinct().forEach(System.out::println);


        List<String> list3 = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");
        List<String[]> collect = list3.stream().map(str -> str.split(" ")).collect(Collectors.toList());
        collect.forEach(arr-> Arrays.stream(arr).distinct().forEach(System.out::println));

        System.out.println("--------------------------------");

        list3.stream().map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


        System.out.println("--------------------------------");

        List<String> la = Arrays.asList("hello", "你好", "HI");
        List<String> lb = Arrays.asList("张三", "李四", "王五");

        la.stream().flatMap(a -> lb.stream().map(b -> a + ", " + b)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
