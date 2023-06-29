package jvm.classloader;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2022-12-20 上午10:51
 */
public class T {

    public static void main(String[] args) {
        System.out.println(MyParent222.str);
    }
}


class MyParent222{
    public static final String str = "hello world";

    public static final int d = 6;

    static {
        System.out.println("MyParent2 static block");
    }
}