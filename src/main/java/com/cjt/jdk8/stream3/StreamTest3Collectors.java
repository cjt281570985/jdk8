package com.cjt.jdk8.stream3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3Collectors {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "q2q", "99");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream().map(x->x*x).forEach(System.out::println);

        Stream<String> stream1 = Stream.of("hello", "world", "q2q", "99");
        //List list = stream1.collect(Collectors.toList());
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
