package com.cjt.jdk8.supplier;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/1/7.
 */
public class StudentTest {

    public static void main(String[] args) {

        Supplier<Student> supplier = ()-> new Student() ;
        System.out.println(supplier.get().getName());

        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get().getAge());

    }


}
