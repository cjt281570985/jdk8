package jdk8.supplier;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by Administrator on 2017/1/8.
 */
public class BinaryOperatorTest3 {

    public static void main(String[] args) {

        BinaryOperatorTest3.compoe(3, 5, Integer::sum);
        BinaryOperatorTest3.compoe(15, 5, (a, b) -> a-b);
        BinaryOperatorTest3.compoe(15, 5, (a, b) -> a/b);
        BinaryOperatorTest3.compoe(15, 5, (a, b) -> a*b);

        BinaryOperatorTest3.min(145, 35, Integer::compareTo);

    }

    public static int compoe(int a, int b, BinaryOperator<Integer> fun){
        int rs = fun.apply(a, b);
        System.out.println(rs);
        return rs;
    }

    public static int min(int a, int b,  Comparator<Integer> comparator){

        int rs = BinaryOperator.minBy(comparator).apply(a, b);
        System.out.println(rs);
        return rs;
    }


}
