package guava.collections;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MapsTest {

    @Test
    public void test(){
        List<String> list = Lists.newArrayList("1", "2", "3", "4");

        //不可变map
        ImmutableMap<String, String> immutableMap = Maps.uniqueIndex(list, k -> k + "_key");
        System.out.println(immutableMap);//{1_key=1, 2_key=2, 3_key=3, 4_key=4}

        //可变map
        Map<String, String> map = Maps.asMap(Sets.newHashSet("1", "2", "3"), k -> k + "_val");
        System.out.println(map);//{1=1_val, 2=2_val, 3=3_val}

        Map<String, String> transMap = Maps.transformValues(map, v -> v + "_tran");
        System.out.println(transMap);//{1=1_val_tran, 2=2_val_tran, 3=3_val_tran}

        //过滤map的key
        Map<String, String> filterMap = Maps.filterKeys(map, k -> Lists.newArrayList("1", "2").contains(k));
        System.out.println(filterMap);//{1=1_val, 2=2_val}

        //Joiner实例是线程安全的
        Joiner.MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(filterMap));//1=1_val,2=2_val
    }

    @Test
    public void testLinkedListMultimap() {
        LinkedListMultimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("a", "111");
        multimap.put("a", "666");
        multimap.put("c", "333");

        System.out.println(multimap); //{a=[111, 666], c=[333]}
        System.out.println(multimap.get("a")); // [111, 666]
    }

}
