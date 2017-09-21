package com.cjt.jdk8.methodreference;

import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/1/14.
 */
public class MethodReferenceTest {

    public String getString(Supplier<String> supplier){
        return supplier.get()+"test";
    }
    public String getString2(String str, Function<String, String> function){
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student student1 = new Student("lhq", 60);
        Student student2 = new Student("yzy", 80);
        Student student3 = new Student("cjt", 100);
        Student student4 = new Student("csh", 90);
        Student student5 = new Student("gyh", 70);

        //方法引用共分为4类
        //1.类名::静态方法名
        //2.对象名::实例方法名
        //3.类名::实例方法名
        //4.构造方法 类名::new
        //语法糖
        List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5);

        List<Integer> integers = Arrays.asList(1, 2, 3, 5);
//        integers.forEach(val -> System.out.println(val));
//        System.out.println("---------------------");
//        integers.forEach(System.out::println);

        System.out.println("----------1.类名::静态方法名-----------");
        studentList.sort(StudentUtil::compareStudentByNameStatic);
        studentList.sort(StudentUtil::compareStudentByScoreStatic);
        studentList.forEach(System.out::println);

        System.out.println("----------2.对象名::实例方法名-----------");
        StudentUtil util = new StudentUtil();
        studentList.sort(util::compareStudentByName);
        studentList.forEach(System.out::println);

        System.out.println("----------3.类名::实例方法名-----------");
        studentList.sort(Student::compareStudentByScore);
        studentList.forEach(System.out::println);

        System.out.println("----------4.构造方法 类名::new-----------");
        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get().getName());

        MethodReferenceTest test = new MethodReferenceTest();
        System.out.println(test.getString2("cjt", String::new));


    }
}
