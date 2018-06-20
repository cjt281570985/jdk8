package jdk8.stream3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-06-06 11:17
 */
public class TestRemoveRepeatList {

  public static void main(String[] args) {

    List<Student> userList = new ArrayList<>();
    Student student =new Student("吉米", 90);
    Student student1 =new Student("yzy", 80);
    Student student2 =new Student("吉米", 100);
    Student student3 =new Student("cjt", 80);



    userList.add(student);
    userList.add(student1);
    userList.add(student2);
    userList.add(student3);



    List<Student> arrayList = userList.stream().collect(
        Collectors.collectingAndThen(
            Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new)
    );

    List<Student> arrayList2 = userList.stream().collect(
        Collectors.collectingAndThen(
            Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getScore))), ArrayList::new)
    );

    System.out.println(arrayList);
    System.out.println(arrayList2);

  }

}
