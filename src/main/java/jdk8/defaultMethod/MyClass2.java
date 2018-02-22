package jdk8.defaultMethod;

/**
 * Created by Administrator on 2017/1/15.
 */
public class MyClass2 extends MyInterface1Impl implements MyInterface2 {

    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.myDefaultMethod();
    }
}
