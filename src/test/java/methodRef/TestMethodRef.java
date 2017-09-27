package methodRef;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class TestMethodRef {


    public static void main(String[] args) {

        Student student1 = new Student("jimmy", 80);
        Student student2 = new Student("cjt", 90);
        Student student3 = new Student("yzy", 70);
        Student student4 = new Student("lhq", 100);

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4);

        studentList.sort((stu1, stu2)-> StuUtil.compareByNameStatic(stu1,stu2));

        //方法引用共分为4类
        //1.类名::静态方法名
        //2.对象名::实例方法名
        //3.类名::实例方法名
        //4.构造方法 类名::new

        System.out.println("-----------1.类名::静态方法名-------------");
        studentList.sort(StuUtil::compareByNameStatic);
        studentList.sort(StuUtil::compareByScoreStatic);
        studentList.forEach(System.out::println);

        StuUtil util = new StuUtil();
        System.out.println("-----------2.对象名::实例方法名-------------");
        studentList.sort(util::compareByName);
        studentList.sort(util::compareByScore);
        studentList.forEach(System.out::println);

        System.out.println("-----------3.类名::实例方法名-------------");
        studentList.sort(Student::compareByName);
        studentList.sort(Student::compareByScore);
        studentList.forEach(System.out::println);

        System.out.println("-----------4.构造方法 类名::new-------------");
        Supplier<Student> studentSupplier =  Student::new;
        System.out.println(studentSupplier.get().getName());


    }
}
