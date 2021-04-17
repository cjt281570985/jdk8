package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-24 23:26
 */
public class SetTest {

    //当重写equals时, 必须要重写hashCode方法, 如果一个类的2个对象使用equals方法比较时,若为true,则这2个对象必须具有相同的hashCode
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();
        set.add(new Student("cjt"));
        set.add(new Student("jimmy"));
        set.add(new Student("cjt"));

        System.out.println(set);
        set.forEach(System.out::println);

    }

}

class Student {
    private String name;

    public String getName() {
        return this.name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            return stu.name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
