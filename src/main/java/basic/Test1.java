package basic;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-19 07:27
 */
public class Test1 {

    //为什么对一个public类型的终太的成员变量,一般都要声明为static?
    //所有的对象都引用同一个静态变量, 减少内存使用
    public static final String jimmy ="abc";


    //对final类型的成员变量的初始化方式
    //1.声明变量时直接赋值
    //2.要构造方法中完成赋值. 如果一个类有多个构造方法,就要保证在每个构造方法中都要完成对final类型变量的初始化工作

    private final int a;   //在所有构造方法中需要对final进行赋值

    private String name;

    public Test1() {
        a = 3;
    }

    public Test1(String name) {
        a = 4;
        this.name = name;
    }
}
