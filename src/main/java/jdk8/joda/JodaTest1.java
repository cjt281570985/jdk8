package jdk8.joda;

import org.joda.primitives.list.IntList;
import org.joda.primitives.list.impl.ArrayIntList;

/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest1 {

    public static void main(String[] args) {

        IntList intList = new ArrayIntList();
        intList.add(5);
        intList.add(8);
        intList.add(6);

        intList.forEach(System.out::println);

    }

}
