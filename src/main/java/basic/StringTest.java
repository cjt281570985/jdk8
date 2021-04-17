package basic;

import java.util.Map;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-16 19:43
 */
public class StringTest {

    public static void main(String[] args) {

        //s不是对象, 是对象的地址
        //只有String有个 pool   生成字符串对象时,先在池里找有没有  abc,  生成的 new String() 是在堆里面的
        String s = new String("abc");

        String s1 = "abc";

        String s2 = new String("abc");


        //对引用类型来说==号比较的是内存的地址 (原生数据比较的是值)
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s1 == s2);


        System.out.println(s.equals(s1));
        System.out.println(s.equals(s2));
        System.out.println(s1.equals(s2));

        System.out.println("--------------------------------");
        System.out.println(s == s.intern());
        System.out.println(s1 == s1.intern());
        System.out.println(s.intern() == s2.intern());

        System.out.println("--------------------------------");

        String hello = "hello";
        String he = "he";
        String llo = "llo";

        //如果==号2边都是常量值的话,拼完会在常量池检查有没有对应的值
        System.out.println(hello == "he" + "llo"); //true
        //如果有不是常量(变量), 不检查常量池了, 直接在堆中创建对象
        System.out.println(hello == "he" + llo); //false

        Map map;
    }

}
