package jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时,并不要求父接口都完成初始化
 * 只有在真正使用到父接口的时候(如引用接口中定义的常量时)才会初始化
 */
public class MyTest6 {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);


    }

}

class Singleton {

    public static int counter1 = 1;


    private static Singleton singleton = new Singleton();

    public Singleton() {
        counter1++;
        counter2++;//准备阶段的重要意义

        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }

}
