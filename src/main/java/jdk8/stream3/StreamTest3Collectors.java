package jdk8.stream3;


import java.util.*;
import java.util.stream.Collectors;


public class StreamTest3Collectors {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4);


        List<Student> students1 = studentList.stream().collect(Collectors.toList());
        students1.forEach(System.out::println);

        System.out.println("count: " + studentList.stream().collect(Collectors.counting()));
        System.out.println("count: " + studentList.stream().count());
        System.out.println("--------------------");

        //Optional
        Optional<Student> minStu = studentList.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore)));
        System.out.println(minStu.get());
        studentList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(studentList.stream().collect(Collectors.averagingDouble(Student::getScore)));
        ;
        System.out.println(studentList.stream().collect(Collectors.summingInt(Student::getScore)));
        ;

        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);

        System.out.println(studentList.stream().map(Student::getName).collect(Collectors.joining()));
        System.out.println(studentList.stream().map(Student::getName).collect(Collectors.joining("-")));
        System.out.println(studentList.stream().map(Student::getName).collect(Collectors.joining("-", "A", "B")));

        //{80={zhangsan=[Student{name='zhangsan', score=80'}]}, 100={wangwu=[Student{name='wangwu', score=100'}]},
        // 90={lisi=[Student{name='lisi', score=90'}], zhaoliu=[Student{name='zhaoliu', score=90'}]}}
        Map<Integer, Map<String, List<Student>>> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(collect);

        System.out.println(studentList.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() > 80, Collectors.partitioningBy(stu -> stu.getScore() > 90))));

        Map<Boolean, Long> longMap = studentList.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() > 80, Collectors.counting()));
        System.out.println(longMap);

        Map<String, Optional<Student>> optionalMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.minBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(optionalMap);
        //在名字分组一定存在分数,一定有值,需要将值取出来
        Map<String, Student> studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(studentMap);
        System.out.println("--------------------------------");
        Map<Integer, List<Student>> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getScore));
        Map<Integer, List<String>> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(collect1);
        System.out.println(collect2);



    }

}
