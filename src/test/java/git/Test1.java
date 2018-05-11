package git;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import jdk8.stream3.Student;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-05-11 10:29
 */
public class Test1 {
  public static void main(String[] args) {
    Student stu1 = new Student("zhangsan", 100, 20, "15985857701");
    Student stu2 = new Student("lisi", 90, 20, "15985857702");
    Student stu3 = new Student("wangwu", 70, 30, "15985857703");
    Student stu4 = new Student("lisi", 80, 40, "15985857704");

    List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4);

    //该方法不能有重复的key
    Map<String, Integer> maps = studentList.stream().collect(Collectors.toMap(Student::getName, Student::getScore));
    System.out.println(maps);

    Map<String, String> stringMap = studentList.stream().collect(Collectors
        .toMap(Student::getName, Student::getPhone, (s, a) -> s + "->" + a));
    System.out.println(stringMap);

    Map<String, Long> mapRs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
    Set<Entry<String, Long>> entries = mapRs.entrySet();
    System.out.println(entries);
    Optional<Entry<String, Long>> max = entries.stream().max(Map.Entry.comparingByValue());
    System.out.println(max.get().getKey() + " = " + max.get().getValue()); //lisi = 2
    //System.out.println(max.map(Map.Entry::getKey).get() + " = " + max.map(Map.Entry::getValue).get());

    Optional<String> rs = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey);
    System.out.println(rs); //Optional[lisi]

  }
}
