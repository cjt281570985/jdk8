package guava.collections;

import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ListsTest {

    @Test
    public void test() {
        List<List<String>> lists = Lists.cartesianProduct(Lists.newArrayList("1", "2"), Lists.newArrayList("A", "B"));
        System.out.println(lists);//[[1, A], [1, B], [2, A], [2, B]]

        ArrayList<String> sourceList = Lists.newArrayList("cjt", "Jimmy", "yzy");
        Lists.transform(sourceList, String::toUpperCase).forEach(System.out::println);

        ArrayList<String> rs = Lists.newArrayListWithCapacity(10);
        rs.add("a");
        rs.add("b");
        rs.add("c");
        System.out.println("rs: " + rs);

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> reverse = Lists.reverse(integers);
        reverse.forEach(System.out::println);
    }

    @Test
    public void testParttion() {
        ArrayList<String> list = Lists.newArrayList("cjt", "yzy", "zlf", "jimmy", "666", "888", "hello");
        List<List<String>> partition = Lists.partition(list, 3);
        System.out.println(partition);//[[cjt, yzy, zlf], [jimmy, 666, 888], [hello]]

        System.out.println(IntMath.divide(10, 3, RoundingMode.CEILING));//4
    }

}
