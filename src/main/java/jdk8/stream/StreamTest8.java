package jdk8.stream;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest8 {

    public static void main(String[] args) {
        //流的短路
        List<String> list = Arrays.asList("hello", "world56753扔", "cjt21321");
        list.stream().mapToInt(item ->
                {
                    int length =  item.length();
                    System.out.println("test.....");
                    return  length;
                }

        ).filter(length->length>5).findFirst().ifPresent(System.out::println);
    }
}
