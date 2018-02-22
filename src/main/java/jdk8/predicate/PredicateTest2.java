package jdk8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/1/6.
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        PredicateTest2.conditionFilter(list, item -> item%2 == 0);
        System.out.println("-------------------------");
        PredicateTest2.conditionFilter(list, item -> item%3 == 0);
        System.out.println("-------------------------");
        PredicateTest2.conditionFilter(list, item -> false);

        System.out.println("----------and---------------");
        PredicateTest2.conditionAndFilter(list, item -> item>5, item -> item%2==0);
        System.out.println("----------------------------");
        System.out.println(PredicateTest2.testEq("cjt").test("cjt"));
    }


    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer : list){
            if (predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    public static void conditionAndFilter(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        for (Integer integer : list){
            if (predicate1.and(predicate2).negate().test(integer)){ //negate取反,此处去掉6 8 10
                System.out.println(integer);
            }
        }
    }

    public static Predicate<String> testEq(Object object){
        return Predicate.isEqual(object);
    }
}
