package guava.collections;

import com.google.common.collect.BoundType;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RangeTest {

    /**
     * a<=x<=b
     */
    @Test
    public void testRangeClosed() {
        Range<Integer> rangeClosed = Range.closed(1, 5);
        System.out.println(rangeClosed);//[1..5]
        System.out.println(rangeClosed.contains(1));//true
        System.out.println(rangeClosed.contains(5));//true
        System.out.println(rangeClosed.contains(6));//false
        System.out.println(rangeClosed.lowerEndpoint());//1
        System.out.println(rangeClosed.upperEndpoint());//5
    }

    /**
     * a<x<b
     */
    @Test
    public void testOpenRange() {
        Range<Integer> open = Range.open(1, 5);
        System.out.println(open);//(1..5)
        System.out.println(open.contains(1));//false
        System.out.println(open.contains(5));//false
        System.out.println(open.contains(6));//false
        System.out.println(open.lowerEndpoint());//1
        System.out.println(open.upperEndpoint());//5
    }

    /**
     * a<x<=b
     * OpenClose  不包含open包含close
     */
    @Test
    public void testOpenClose() {
        Range<Integer> open = Range.openClosed(1, 5);
        System.out.println(open);//(1..5]
        System.out.println(open.contains(1));//false
        System.out.println(open.contains(5));//true
        System.out.println(open.contains(6));//false
        System.out.println(open.lowerEndpoint());//1
        System.out.println(open.upperEndpoint());//5
        System.out.println(open.lowerBoundType());//OPEN
        System.out.println(open.upperBoundType());//CLOSED
    }

    @Test
    public void greaterThan() {
        Range<Integer> integerRange = Range.greaterThan(10);
        System.out.println(integerRange); //(10..+∞)
        System.out.println(integerRange.contains(10)); //false
        System.out.println(integerRange.contains(Integer.MAX_VALUE)); //true
        //比较上下界
        //integerRange.isConnected()
    }

    @Test
    public void range() {
        TreeMap<String, Integer> treeMap = Maps.newTreeMap();
        treeMap.put("Scala", 1);
        treeMap.put("Guava", 2);
        treeMap.put("Kafka", 3);
        treeMap.put("Java", 4);

        System.out.println(treeMap);//{Guava=2, Java=4, Kafka=3, Scala=1}

        NavigableMap<String, Integer> navigableMap = Maps.subMap(treeMap, Range.open("F", "K"));
        System.out.println(navigableMap);//{Guava=2, Java=4}
    }

    @Test
    public void testOther() {
        Range<Integer> atLeast = Range.atLeast(5);
        System.out.println(atLeast);//[5..+∞)
        System.out.println(atLeast.contains(5));//true

        Range<Integer> lessThan = Range.lessThan(10);
        System.out.println(lessThan);//(-∞..10)
        System.out.println(Range.atMost(5));//(-∞..5]
        System.out.println(Range.all());//(-∞..+∞)
        System.out.println(Range.downTo(6, BoundType.CLOSED));//[6..+∞)
        System.out.println(Range.upTo(6, BoundType.OPEN));//(-∞..6)
    }

    @Test
    public void testRangeMap() {
        TreeRangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(0, 60), "不及格");
        rangeMap.put(Range.closed(61, 70), "及格");
        rangeMap.put(Range.closed(71, 80), "良好");
        rangeMap.put(Range.closed(81, 100), "优秀");

        System.out.println(rangeMap.get(50));//不及格
        System.out.println(rangeMap.get(66));//及格
        System.out.println(rangeMap.get(77));
        System.out.println(rangeMap.get(81));//优秀

        System.out.println(rangeMap); //[[0..60]=不及格, [61..70]=及格, [71..80]=良好, [81..100]=优秀]
    }
}
