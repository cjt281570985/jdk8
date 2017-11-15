package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/3/10.
 */
public class MyComparatorTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("nihao", "welcome", "cjtabcdefg", "world", "hello");
      //  Collections.sort(list, (item1, item2) ->  item1.length() - item2.length());
        //下面加了reversed()就推断不出来item类型
        //Collections.sort(list, Comparator.comparingInt(item -> item.length()).reversed());
       // Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        //以下参数类型推荐不出来
      //  Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());


        //list.sort(Comparator.comparingInt( (String item) -> item.length()).reversed());
         list.sort(Comparator.comparingInt(String::length).reversed());
        //[nihao, world, hello, welcome, cjtabcdefg]
        //[hello, nihao, world, welcome, cjtabcdefg]
        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        list.sort(Comparator.comparingInt(String::length).thenComparing((item1, item2)-> item1.toUpperCase().compareTo(item2.toUpperCase())));
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase)));
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase))); //[hello, nihao, world, welcome, cjtabcdefg]



        list.sort(Comparator.comparingInt(String::length).
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder()))); //[world, nihao, hello, welcome, cjtabcdefg]

        list.sort(Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder()))); //[cjtabcdefg, welcome, world, nihao, hello]

        System.out.println(list);

        System.out.println("--------------------------------");

        Student stu1 = new Student("zhangsan", 100, 20);
        Student stu2 = new Student("lisi", 90, 20);
        Student stu3 = new Student("wangwu", 70, 30);
        Student stu4 = new Student("lisi", 80, 40);

        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4);
        studentList.sort(Comparator.comparingInt(Student::getAge));
        studentList.stream().forEach(System.out::println);

        List<String> list2 = Arrays.asList("nihao", "welcome", "cjtabcdefg", "world", "hello");
        list2.stream().sorted(String::compareTo);

    }


}
