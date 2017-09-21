package com.cjt.jdk8.stream2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/5/14.
 */
public class TestPrimeNumber {

    //测试质数

    public static void main(String[] args) {

        System.out.println(TestPrimeNumber.isPrime(8));;
        System.out.println(IntStream.range(2,3).noneMatch(i -> 7%i==0));

        Map<Boolean, List<Integer>> collect = IntStream.range(2,40).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(collect);


    }




    public static boolean isPrime(int candidate) {
        int candidateSqrt = (int)Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateSqrt).noneMatch(i -> candidate%i==0);
    }
}
