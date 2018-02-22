package guava.collections;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

public class Multimaps {

    @Test
    public void test() {

        LinkedListMultimap<String, String> multimap = LinkedListMultimap.create();
        HashMap<String, String> hashMap = Maps.newHashMap();

        multimap.put("1", "1");
        multimap.put("1", "2");
        hashMap.put("1", "1");
        hashMap.put("1", "2");

        System.out.println("multimap: " + multimap);//{1=[1, 2]}
        System.out.println("hashMap: " + hashMap);//{1=2}

    }
}
