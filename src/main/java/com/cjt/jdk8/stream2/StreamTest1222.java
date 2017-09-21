package com.cjt.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Administrator on 2017/2/17.
 */
public class StreamTest1222 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student>  studentList = Arrays.asList(student1, student2, student3, student4);

        System.out.println("---------------");
        Map<Integer, List<Student>> ms = studentList.stream().collect(Collectors.groupingBy(Student::getScore, toList()));
        System.out.println(ms);



    }

}
