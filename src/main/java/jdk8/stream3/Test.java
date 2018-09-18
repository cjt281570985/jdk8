package jdk8.stream3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("111", "555", "hello word","211","asdf32");
        List<String> list2 = new ArrayList<>();
        list2.add("cjt");
        list2.add("bbb");
        list2.add("zzz");
        list2.add("dsd");
        list.stream().map(a->a+"99999").forEach(System.out::println);
        //list.forEach(System.out::println);

    }
}
