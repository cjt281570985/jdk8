package jdk8.supplier;

/**
 * Created by Administrator on 2017/1/7.
 */
public class Student {

    private String name = "zhangsan";
    private int age = 23;

    public Student( ) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
