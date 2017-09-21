package com.cjt.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Administrator on 2016/12/31.
 */
public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(5, value -> value + 3, value -> value * value)); //28
        System.out.println(test.compute2(3, value -> value + 2, value -> value * value));//25

        //BiFunction 2个参数得到1个结果
        System.out.println(test.compute3(5, 7, (value1, value2) -> value1+value2));//12
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(Integer a, Integer b, BiFunction<Integer, Integer, Integer> function){
        return function.apply(a, b);
    }


}
