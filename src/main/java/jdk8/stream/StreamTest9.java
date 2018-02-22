package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest9 {

    public static void main(String[] args) {
        //拆分字符串, 并去重
        List<String> list = Arrays.asList("hello world", "cjt world", "hello cjt", "cjt yzy");
        List<String[]> rs = list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList());
        rs.forEach(item->Arrays.asList(item).forEach(System.out::println));

        System.out.println("--------------");
        //flatMap(Arrays::stream)  20
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);


    }
}
