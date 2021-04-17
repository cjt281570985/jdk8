package basic;

import java.io.*;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-11 16:15
 */
public class TestClone3 {

    public static void main(String[] args) throws Exception {
        Teacher3 teacher = new Teacher3(30, "李小龙");
        Students3 stu = new Students3(11, "张三", teacher);

        Students3 stu2 = (Students3)stu.deepCopy();
        stu2.getTeacher().setAge(35);
        stu2.getTeacher().setName("李四");

        System.out.println(stu);
        System.out.println(stu2);

    }

}


//使用序列化的 深拷贝
class Teacher3 implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher3(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name + ", " + age;
    }
}

class Students3 implements Serializable {
    private int age;
    private String name;
    private Teacher3 teacher;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher3 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher3 teacher) {
        this.teacher = teacher;
    }

    public Students3(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Students3(int age, String name, Teacher3 teacher) {
        this.age = age;
        this.name = name;
        this.teacher = teacher;
    }

    public Object deepCopy() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    @Override
    public String toString() {
        return this.name + ", " + age + ", 老师name: " + this.getTeacher().getName() + ", 老师age: " + this.getTeacher().getAge();
    }
}