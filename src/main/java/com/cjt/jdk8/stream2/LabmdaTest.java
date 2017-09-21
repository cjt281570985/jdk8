package com.cjt.jdk8.stream2;

/**
 * Created by Administrator on 2017/4/27.
 */
public class LabmdaTest {


    //lambda表达式作用域为外层作用域,并非内部类的一种语法糖
    //匿名内部类作用域是

    Runnable r1 = () -> System.out.println(this);


    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };


    public static void main(String[] args) {

        LabmdaTest  test = new LabmdaTest();
        Thread t1 = new Thread(test.r1);
        t1.start();
        System.out.println("-----------------");
        Thread t2 = new Thread(test.r2);
        t2.start();


    }



}
