package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-19 06:45
 */
public class ExceptTest {

    public static void main(String[] args) throws Exception {
        Parent1 p1 = new Child1();
        p1.out();
    }
}

//关于重写
//1.子类中方法与父类中的方法有相同的返回类型,名称和参数列表
//2.子类中的方法的访问级别不能低于父类中该方法的访问级别
//3.子类中方法抛出的异常范围不能大于父类中异常的范围 (或者子类不抛出异常)

class Parent1 {

    private String name;

    public void out() throws Exception {
        System.out.println("parent");

    }
}

class Child1 extends Parent1 {

    public String name;

    public void out()  {
        System.out.println("child");

    }
}