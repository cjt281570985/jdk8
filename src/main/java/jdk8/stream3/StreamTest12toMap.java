package jdk8.stream3;



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
//        Map<String, Integer> maps = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getScore));
//        System.out.println(maps);

        Map<String, String> stringMap = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getPhone, (s, a) -> s + "-" + a));
        System.out.println(stringMap);

        Map<String, Long> mapRs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        Set<Map.Entry<String, Long>> entries = mapRs.entrySet();
        System.out.println(entries);
        Optional<Map.Entry<String, Long>> max = entries.stream().max(Map.Entry.comparingByValue());
        System.out.println(max.get().getKey() + " = " + max.get().getValue()); //lisi = 2
        //System.out.println(max.map(Map.Entry::getKey).get() + " = " + max.map(Map.Entry::getValue).get());

        Optional<Long> rs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue);
        System.out.println(rs); //Optional[lisi]

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting())));

    }
}
