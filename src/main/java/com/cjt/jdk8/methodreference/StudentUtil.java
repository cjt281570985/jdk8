package com.cjt.jdk8.methodreference;

/**
 * Created by Administrator on 2017/7/20.
 */
public class StudentUtil {

    public static int compareStudentByScoreStatic(Student student1, Student student2){
        return  student1.getScore() - student2.getScore();
    }
    public static int compareStudentByNameStatic(Student student1, Student student2){
        return  student1.getName().compareToIgnoreCase(student2.getName());
    }


    public  int compareStudentByScore(Student student1, Student student2){
        return  student1.getScore() - student2.getScore();
    }
    public  int compareStudentByName(Student student1, Student student2){
        return  student1.getName().compareToIgnoreCase(student2.getName());
    }
}
