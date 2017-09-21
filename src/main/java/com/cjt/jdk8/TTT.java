package com.cjt.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TTT {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,5,77,345,5,2);
        List<Integer> list1 = Arrays.asList(13,11,15,177,1345,12,00,87);
        //System.out.println(list1.size());
        //System.out.println(list.set(2,999));
        System.out.println("-------------");
       Collections.copy(list1, list);
        //Collections.swap(list1,2,6);
        //
        System.out.println(Collections.lastIndexOfSubList(list, Arrays.asList(5,77)));
        //list.forEach(System.out::println);
        //System.out.println(Collections.max(list));
       // Collections.unmodifiableCollection()

    }

}
