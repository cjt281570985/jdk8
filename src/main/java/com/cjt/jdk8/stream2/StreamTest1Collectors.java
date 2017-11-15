package com.cjt.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by Administrator on 2017/2/17.
 */
public class StreamTest1Collectors {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student>  studentList = Arrays.asList(student1, student2, student3, student4);

        //import static java.util.stream.Collectors.*;  静态导入 Collectors.toList()
        List<Student> students1 = studentList.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("--------------------");

        //import static java.util.stream.Collectors.*;  静态导入 Collectors.counting()
        //调用方法都能实现的情况下,尽量使用最具体的方法
        //1.collect 收集器
        //2.Collector是作为collect()方法参数
        //3.Collector是一个接口,它是一个可变的汇聚操作,将输入元素累积到一个可变的容器中,它会在所有元素处理完毕后,
        // 将累积的结果转换为一个最终的表示(这是一个可选操作).它支持串行与并行操作
        //4.Collectors本身提供了关于Collector的常见汇聚实现,Collectors本身实际上是一个工厂
        //5.为了确保串行与并行 操作结果的等价性,Collector函数需要满足2个条件:identity(同一性)与 associativity(结合性).
        //6. a = combiner.apply(a, supplier.get())  这个就是同一性
        //7.函数式编程最大的特点: 表示做什么, 而不是如何做.


        //Function<R,RR> finisher

        //combiner函数,有4个线程同时执行.那么就会生成4个部分结果
        System.out.println("count: " + studentList.stream().collect(counting()));
        System.out.println("count: " + studentList.stream().count());

        System.out.println("---------最 值-25----------");
        studentList.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        studentList.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(studentList.stream().collect(averagingDouble(Student::getScore)));;
        System.out.println(studentList.stream().collect(summingInt(Student::getScore)));;

        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);

        System.out.println(studentList.stream().map(Student::getName).collect(joining()));;
        System.out.println(studentList.stream().map(Student::getName).collect(joining(", ")));;
        System.out.println(studentList.stream().map(Student::getName).collect(joining(", ", "AAA", "BBB")));;


        Map<Integer, Map<String, List<Student>>> map = studentList.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);
        System.out.println(studentList.stream().collect(partitioningBy(student -> student.getScore()>80, partitioningBy(student -> student.getScore()>90))));
        System.out.println(studentList.stream().collect(partitioningBy(student -> student.getScore()>80, counting())));
        //collectingAndThen  Optional::get  第25后面
        //在名字分组一定存在分数,一定有值,需要将值取出来
        Map<String, Student> map1 = studentList.stream().collect(groupingBy(Student::getName,
                collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));

        System.out.println("------------999999999--------------");
        Map<Integer, Set<String>> map2 = studentList.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.mapping(Student::getName, Collectors.toSet())));
        System.out.println(map2);  //{80=[zhangsan], 100=[wangwu], 90=[lisi, zhaoliu]}

        System.out.println("---------------");
        Map<Integer, List<Student>> ms = studentList.stream().collect(Collectors.groupingBy(Student::getScore, toList()));
        System.out.println(ms);

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getScore)));

    }

}
