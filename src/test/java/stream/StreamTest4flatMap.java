package stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest4flatMap {

    public static void main(String[] args) {

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(1,2,3), Arrays.asList(4,5,6));
        listStream.flatMap(list -> list.stream()).distinct().forEach(System.out::println);

        List<String> list1 = Arrays.asList("hello", "你好", "HI");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");

        list1.stream().flatMap(a -> list2.stream().map(b -> a + "," + b)).forEach(System.out::println);
        System.out.println("----------------------");
        List<String> list = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");
        list.stream().map(a->a.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
        System.out.println("----------------------");
        list.stream().map(a->a.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println("----------------------");


        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 30).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 30)
                                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }
}
