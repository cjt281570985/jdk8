package jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest11Group {

    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 100, 20);
        Student stu2 = new Student("lisi", 30, 20);
        Student stu3 = new Student("wangwu", 90, 30);
        Student stu4 = new Student("lisi", 60, 30);
        Student stu5 = new Student("lisi", 80, 60);

        //分组
        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4, stu5);
        Map<Integer, List<Student>> map =  studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map);

        //select name, count(*) from student group by name
        Map<String, Long> map2 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(map2);

        Map<String, Double> map3 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map3);

        //分区操作, 是分组的一种特例
        Map<Boolean, List<Student>> map5 = studentList.stream().collect(Collectors.partitioningBy(student -> student.getScore()>80));
        System.out.println(map5);

    }
}
