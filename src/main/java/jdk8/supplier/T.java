package jdk8.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-02 21:26
 */
public class T {


  public static void main(String[] args) {

    List<String> names = Arrays.asList("cjt", "chenjt", "yzy");

    List<Person> studentList = names.stream().map(Person::new).collect(Collectors.toList());

    System.out.println(studentList);

    Person student = new Person("zlf");
    Stream.of(student).map(Person::new).collect(Collectors.toList());


  }

}
