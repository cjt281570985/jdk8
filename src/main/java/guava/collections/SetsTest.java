package guava.collections;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsTest {

    @Test
    public void test() {
        HashSet<Integer> integers = Sets.newHashSet(1, 2, 3, 1);
        System.out.println(integers);

        //笛卡尔积
        Set<List<Integer>> lists = Sets.cartesianProduct(Sets.newHashSet(1, 2), Sets.newHashSet(3, 4), Sets.newHashSet(5,6));
        System.out.println(lists);//[[1, 4, 5], [1, 4, 6], [1, 3, 5], [1, 3, 6], [2, 4, 5], [2, 4, 6], [2, 3, 5], [2, 3, 6]]

        HashSet<Integer> ints = Sets.newHashSet(1, 2, 3);
        Set<Set<Integer>> combinations = Sets.combinations(ints, 2);
        combinations.forEach(System.out::println);
    }

    @Test
    public void testDiff() {
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(1, 4, 6);

        //差集
        Sets.SetView<Integer> difference = Sets.difference(set1, set2);
        System.out.println("差集: " +difference);//[2, 3]
        System.out.println("差集: " +Sets.difference(set2, set1));//[4, 6]

        //交集
        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        System.out.println("交集: " +intersection); //[1]

        //并集
        Sets.SetView<Integer> union = Sets.union(set1, set2);
        System.out.println("并集: " +union); //[1, 2, 3, 4, 6]
    }
}
