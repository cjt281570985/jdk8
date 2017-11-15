package com.cjt.jdk8.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest3 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "qq");
        //String[] arr = stream.toArray(length -> new String[length]);
        String[] arr = stream.toArray(String[]::new);
        Arrays.asList(arr).forEach(System.out::println);

        Stream<String> stream1 = Stream.of("hello", "world", "q2q", "99");
        List list = stream1.collect(Collectors.toList());



        //List list = stream1.collect(() -> new ArrayList(), ((list1, str) -> list1.add(str)), (list1, list2) -> list1.addAll(list2));
//        List list = stream1.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        list.forEach(System.out::println);
//        System.out.println("--------------------------");

       String s = stream1.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
       // String concat = stream1.collect(StringBuilder::new, StringBuilder::append,StringBuilder::append).toString();
        System.out.println(s);

        System.out.println("--------------------------");
        Stream<String> stream11 = Stream.of("xhello111", "world111", "111q2q", "11199");
        //Collectors.toCollection 自定义返回的类型
        //List<String> ls = stream11.collect(Collectors.toCollection(LinkedList::new));
        Set<String> ls = stream11.collect(Collectors.toCollection(TreeSet::new));
        ls.forEach(System.out::println);

        //第17   Collectors
        System.out.println("-----------拼字符串---------------");
        Stream<String> stream22 = Stream.of("bbb", "a232", "xxx", "nnn");
        String ss = stream22.collect(Collectors.joining()).toString();
        System.out.println(ss);
    }
}
