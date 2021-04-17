package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-19 00:19
 */
public class OrderTest {

    public static void main(String[] args) {
        new Child();
    }
}


class Parent {
    static String name = "hello";

    static {
        System.out.println("Parent static");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }
}


class Child extends Parent {
    static String childName = "world";

    static {
        System.out.println("Child static");
    }

    public Child() {
        super();
        System.out.println("Child constructor");
    }
}