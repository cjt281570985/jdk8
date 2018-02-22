package jdk8.stream3;

/**
 * Created by Administrator on 2017/2/16.
 */
public class Student {

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score + '\'' +
                '}';
    }

    private int score;
    private int age;
    private String phone;

    public Student(String name, int score, int age, String phone) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.phone = phone;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;

    }

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
