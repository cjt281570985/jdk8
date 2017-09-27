package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {


    public static void main(String[] args) {

        //collect
        List<String> list = Arrays.asList("hell2o", "world", "99", "99");
        Set<String> collect = list.stream().collect(Collectors.toSet());
        collect.forEach(System.out::println);

        Set<String> ls = list.stream().collect(Collectors.toCollection(TreeSet::new));
        ls.forEach(System.out::println);

        List<String> list1 = Arrays.asList("hell2o", "world", "99", "99");
        String collect1 = list1.stream().collect(Collectors.joining("-"));
        System.out.println(collect1);

        System.out.println("--------------------------------");
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4, 5));
        Stream<Integer> integerStream = listStream.flatMap(list5 -> list5.stream()).distinct().map(a -> a * 3);
        integerStream.forEach(System.out::println);


        //map  filter
        System.out.println("--------------filter------------------");
        List<String> list2 = Arrays.asList("hello5", "world", "cjt");
        list2.stream().map(a -> {
            a = a.toUpperCase();
            System.out.println("this is map");
            return a;
        }).filter(b -> b.length() > 5)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());


    }
}
