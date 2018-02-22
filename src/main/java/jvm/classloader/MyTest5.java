package jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时,并不要求父接口都完成初始化
 * 只有在真正使用到父接口的时候(如引用接口中定义的常量时)才会初始化
 */
public class MyTest5 {

    public static void main(String[] args) {

        System.out.println(MyChild5.b);


    }

}

//接口中的常量 默认是 final, 类中的常量如果没定义为final那它就不是final
interface MyParent5 {
    public static int a = new Random().nextInt(3);
}

interface MyChild5 extends MyParent5 {
    public static int b = 6;
}