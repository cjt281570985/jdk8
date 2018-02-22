package guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

public class BiMapTest {

    @Test
    public void test() {
        HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("1", "2");
        System.out.println(hashBiMap);
        //hashBiMap.put("2", "2"); //value already present: 2
        System.out.println(hashBiMap);
    }

    @Test
    public void testInverse() {
        HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("1", "22");
        hashBiMap.put("3", "44");
        hashBiMap.put("5", "66");
        System.out.println(hashBiMap);//{1=22, 3=44, 5=66}
        BiMap<String, String> inverse = hashBiMap.inverse();//反转是生成新的对象,不改变原map
        System.out.println(hashBiMap);//{1=22, 3=44, 5=66}
        System.out.println(inverse);//{22=1, 44=3, 66=5}
    }

    @Test
    public void testForcePut() {
        HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("1", "22");
        //hashBiMap.put("2", "22");value already present: 22
        hashBiMap.forcePut("2", "22");

        System.out.println(hashBiMap); //{2=22}
    }
}
