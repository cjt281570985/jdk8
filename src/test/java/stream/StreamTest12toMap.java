package stream;



import jdk8.stream3.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jimmy on 2017/7/20
 */
public class StreamTest12toMap {

    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 100, 20, "15985857701");
        Student stu2 = new Student("lisi", 90, 20, "15985857702");
        Student stu3 = new Student("wangwu", 70, 30, "15985857703");
        Student stu4 = new Student("lisi", 80, 40, "15985857704");

        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4);

        //该方法不能有重复的key
        //{lisi=80, zhangsan=100, wangwu=70, lisiq=90}
       Map<String, Integer> maps = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getScore, (a, b) -> a+b));
//        //{lisi=Student{name='lisi', score=80'}, zhangsan=Student{name='zhangsan', score=100'}, wangwu=Student{name='wangwu', score=70'}, lisiq=Student{name='lisiq', score=90'}}
//        Map<String, Student> maps2 = studentList.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        System.out.println(maps);
System.out.println("--------------------------------");
        Map<String, String> stringMap = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPhone, (s, a) -> s + "-" + a));
        System.out.println(stringMap);

        Map<String, Long> mapRs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(mapRs);
        Set<Map.Entry<String, Long>> entries = mapRs.entrySet();
        //[lisi=2, zhangsan=1, wangwu=1]
        System.out.println(entries);

        Optional<Map.Entry<String, Long>> max = entries.stream().max(Map.Entry.comparingByValue());
        //Optional[lisi=2]
        System.out.println(max);
        System.out.println(max.get().getKey() + " = " + max.get().getValue()); //lisi = 2
        System.out.println(max.map(Map.Entry::getKey).get() + " = " +max.map(Map.Entry::getValue).get());//lisi = 2


        Optional<String> rs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        System.out.println(rs); //Optional[lisi]
    }
}
