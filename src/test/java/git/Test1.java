package git;

import java.util.Arrays;
import java.util.List;
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
    Student stu55555555555 = new Student("lisi", 80, 40, "15985857704");

    List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4);

    studentList.stream().map(Student::getName).forEach(System.out::println);


  }
}
