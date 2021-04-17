package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-11 16:15
 */
public class TestClone2 {

    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher(30, "李小龙");
        Students students = new Students(10, "张三", teacher);
        Students students2 = (Students)students.clone();
        System.out.println(students2);
        students2.getTeacher().setName("张三丰");
        System.out.println("--------------------------------");
        System.out.println("students1: " + students);
        System.out.println("students2: " + students2);

    }

}


//需要实现 Cloneable  和 重写 clone()
class Teacher implements Cloneable {
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

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.name + ", " + age;
    }
}

class Students implements Cloneable {
    private int age;
    private String name;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Students(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Students(int age, String name, Teacher teacher) {
        this.age = age;
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        Students students = (Students)super.clone();
        Teacher teacher = (Teacher)students.getTeacher().clone();
        students.setTeacher(teacher);

        return students;
    }

    @Override
    public String toString() {
        return this.name + ", " + age + ", 老师name: " + this.getTeacher().getName() + ", 老师age: " + this.getTeacher().getAge();
    }
}