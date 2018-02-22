package jdk8.supplier;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by Administrator on 2017/1/8.
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {

        System.out.println(BinaryOperatorTest.compute(6, 2, (a, b)->{return a+b;}));
        System.out.println(BinaryOperatorTest.compute(6, 2, (a, b)->{return a-b;}));
        System.out.println(BinaryOperatorTest.compute(6, 2, (a, b)->{return a*b;}));
        System.out.println(BinaryOperatorTest.compute(6, 2, (a, b)->{return a/b;}));

        //System.out.println(BinaryOperatorTest.getShort("hello23", "world", (a, b)->a.length()-b.length()));
        System.out.println(BinaryOperatorTest.getShort("hello23", "world", String::compareTo));
        System.out.println(BinaryOperatorTest.getShort("hello235676", "world", (a, b)->a.charAt(0)-b.charAt(0)));

    }

    public static int compute(int a, int b, BinaryOperator<Integer> function){
        return  function.apply(a, b);
    }

    public static String getShort(String a, String b, Comparator<String> comparator){
        return  BinaryOperator.minBy(comparator).apply(a,b);
    }
}
