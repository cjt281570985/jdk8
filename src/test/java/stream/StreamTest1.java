package stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest1 {

    public static void main(String[] args) {
        //stream 的各种定义形式
        Stream stream1 = Stream.of("aaa", "abc", "lhq");
        String[] arr = {"aaa", "ddd", "ccc"};
        List list = Arrays.asList(arr);

        Stream stream2 = Stream.of(arr);
        Stream stream3 = list.stream();

        //流终止操作
        System.out.println(IntStream.of(1, 2, 3).sum());

        Arrays.asList(arr).forEach(System.out::println);

        IntStream intStream = IntStream.of(new int[]{3, 5, 7});
        intStream.forEach(System.out::println);
        intStream.boxed().forEach(System.out::println);

        System.out.println("--------------------------------");
        IntStream.rangeClosed(1, 6).forEach(System.out::println);

        System.out.println("--------------------------------");

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        System.out.println(list1.stream().map(a -> a * 2).reduce(0, Integer::sum));

        System.out.println("-------------stream-------------------");
        Stream<String> stream = Stream.of("hello", "world", "qq");
        //String[] strings = stream.toArray(length -> new String[length]);
        String[] strings2 = stream.toArray(String[]::new);
        for (String str:strings2) {
            System.out.println(str);
        }


        //对第一个参数(种子) 进行迭代, 无限串行流
        Stream.iterate(1, item->item+2).limit(6).forEach(System.out::println);

        System.out.println("--------------------------------");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,1,3);
        list2.stream().distinct().forEach(System.out::println);

        List<Integer> list3 = Arrays.asList(1,2,3);
        IntSummaryStatistics intSummaryStatistics = list3.stream().mapToInt(a -> a * 2).summaryStatistics();
        System.out.println(intSummaryStatistics);
        System.out.println(list3.stream().mapToInt(a -> a * 2).count());
        System.out.println(list3.stream().mapToInt(a -> a * 2).sum());
        System.out.println(list3.stream().mapToInt(a -> a * 2).min());
        System.out.println(list3.stream().mapToInt(a -> a * 2).average());


    }
}
