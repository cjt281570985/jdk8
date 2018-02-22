package guava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;

public class ImmutableCollections {

    @Test
    public void testof() {
        ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
        //list.add(6);
        System.out.println(list);

        Integer[] arr = {5, 2, 1, 4, 7, 9, 6};
        System.out.println(ImmutableList.copyOf(arr));

        ImmutableList<Integer> builder =
                ImmutableList.<Integer>builder().add(1).add(2, 3, 4).addAll(Arrays.asList(5, 6, 7)).build();
        System.out.println(builder); //[1, 2, 3, 4, 5, 6, 7]

        ImmutableMap<String, String> map =
                ImmutableMap.<String, String>builder().put("Oracle", "12c").put("Mysql", "7.0").build();
        System.out.println(map); //{Oracle=12c, Mysql=7.0}
    }


}
