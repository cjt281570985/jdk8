package guava.collections;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(5, 2, 10, 3, 1, null, 6, 7);
        Collections.sort(list, Ordering.natural().nullsFirst());

        System.out.println(list);//[null, 1, 2, 3, 5, 6, 7, 10]

        Collections.sort(list, Ordering.natural().nullsLast());
        System.out.println(list); //[1, 2, 3, 5, 6, 7, 10, null]


        List<Integer> list2 = Arrays.asList(5, 2, 10, 3, 1, 6, 7);
        List<Integer> list3 = Arrays.asList(1, 6, 7);
        System.out.println(Ordering.natural().isOrdered(list2)); //false
        System.out.println(Ordering.natural().isOrdered(list3)); //true

        Collections.sort(list2,Ordering.natural().reverse());//[10, 7, 6, 5, 3, 2, 1]
        System.out.println(list2);
        Collections.sort(list2,Ordering.natural().reversed());
        System.out.println(list2);
    }
}
