package jdk8.stream3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamTest3Comparator {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("nihao", "welcome","hkllo", "cjtabcdefg", "world", "hello");

        //Collections.sort(list, (str1, str2)-> str1.length()-str2.length());
        System.out.println(list);
        //Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        //Collections.sort(list, Comparator.comparingInt((String str)->str.length()).thenComparing(Comparator.naturalOrder()));
        System.out.println(list);

        //list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER).reversed());
        System.out.println(list);

        list.sort(Comparator.comparing(String::toLowerCase));
        System.out.println(list);

        //[hllo, hello, nihao, world, welcome, cjtabcdefg]
        //[cjtabcdefg, welcome, hello, hkllo, nihao, world]
        //[world, nihao, hkllo, hello, welcome, cjtabcdefg]
        list.sort(Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase)).reversed());

        System.out.println(list);

    }

}
