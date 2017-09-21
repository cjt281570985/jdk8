package com.cjt.jdk8.methodreference;

/**
 * Created by Administrator on 2017/7/20
 */
public class Student {
    private String name = "jimmy";
    private int score;

    public Student() {

    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
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

    public int compareStudentByScore(Student student){
        return  this.getScore() - student.getScore();
    }
    public int compareStudentByName(Student student){
        return  this.getName().compareToIgnoreCase(student.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
