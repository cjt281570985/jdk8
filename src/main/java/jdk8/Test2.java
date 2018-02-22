package jdk8;

/**
 * Created by Administrator on 2016/12/20.
 */

@FunctionalInterface
interface MyInterface {
    void test();

    public  String toString();
}


public class Test2 {

    public void myTest(MyInterface myInterface){
        System.out.println("111");
        myInterface.test();
        System.out.println("111");
    }

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        MyInterface myInterface = ()->{
            System.out.println("test....invoke");
        };

        t2.myTest(myInterface);
        System.out.println("getClass: "+myInterface.getClass());
        System.out.println("getClassLoader: "+myInterface.getClass().getClassLoader());
        System.out.println("getSuperclass: "+myInterface.getClass().getSuperclass());
        System.out.println("getInterfaces: " + myInterface.getClass().getInterfaces()[0]);
    }

}
