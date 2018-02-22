package jdk8;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TTT {

    public static void main(String[] args) {

        System.out.println(isPre(7));
        System.out.println(isPre(8));
        System.out.println(isPre(9));

        Map<Boolean, List<Integer>> listMap = IntStream.rangeClosed(2, 40).boxed().collect(partitioningBy(num -> isPre(num)));
        System.out.println(listMap);

    }

    private static boolean isPre(int num) {
        int mid = ( int ) Math.sqrt(num);
       return  IntStream.rangeClosed(2, mid).noneMatch(i -> num % i == 0);

    }

}
