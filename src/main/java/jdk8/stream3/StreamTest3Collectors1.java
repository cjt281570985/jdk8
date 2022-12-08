package jdk8.stream3;


import com.google.common.base.Joiner;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class StreamTest3Collectors1 {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 88);
        Student student2 = new Student("lisi", 65);
        Student student3 = new Student("lisi", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        List<Student> list2 = new ArrayList<>();
        list2.add(student2);
        list2.add(student3);

        list2.forEach(p -> {
            p.setPhone("99");
        });

        list.removeAll(list2);

        System.out.println(list);

        List<String> list3 = new ArrayList<>();
        list3.add("111");
        list3.add("222");

        System.out.println("--------------------------------");
        List<Object> ls = new ArrayList<>();
        ls.addAll(list);
        ls.addAll(list3);
        System.out.println(ls);

        String url = "/data/storage/file/sjht-config-platform/dev/2022/05/13/379699252751767358.docx";
        String s1 = url.substring(0, url.lastIndexOf("."));
        String suffix = url.substring(url.lastIndexOf(".")); // .docx
        String join = Joiner.on("_").join(s1, System.currentTimeMillis());
        System.out.println(join);
        System.out.println(suffix);
        System.out.println(join + suffix);


    }
}
