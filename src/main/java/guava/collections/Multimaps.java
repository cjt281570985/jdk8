package guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.HashMap;

public class Multimaps {

    @Test
    public void testMultimaps() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("1", "1");
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("5", "25");

        System.out.println("multimap: " + multimap);//multimap: {1=[1, 2, 3], 5=[25]}

        System.out.println(multimap.keys()); //[1 x 3, 5]
        System.out.println(multimap.keySet()); //[1, 5]
        System.out.println(multimap.get("1")); //[1, 2, 3]
    }


    @Test
    public void test2() {

        LinkedListMultimap<String, String> multimap = LinkedListMultimap.create();
        HashMap<String, String> hashMap = Maps.newHashMap();

        multimap.put("1", "1");
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("5", "25");
        hashMap.put("1", "1");
        hashMap.put("1", "2");

        System.out.println("multimap: " + multimap);//{1=[1, 2]}
        System.out.println("hashMap: " + hashMap);//{1=2}

        System.out.println(multimap.keys());
        System.out.println(multimap.keySet());
        System.out.println(multimap.get("1"));

    }
}
