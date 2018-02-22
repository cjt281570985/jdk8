package jdk8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/2/8.
 */
public class test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> predicate = val -> val%2==0;
        Predicate<Integer> predicate2 = val -> val>5;
        for (int a : list){
            if (predicate.and(predicate2).test(a)) {
                System.out.println(a);
            }
        }
    }
}
