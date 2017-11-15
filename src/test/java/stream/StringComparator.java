package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("LHQ", "YZY" , "CJT");
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return -o2.compareTo(o1);
//            }
//        });
        //可写语句或表达式
        //Collections.sort(list,(o1, o2) -> -o2.compareTo(o1));
        //Collections.sort(list,(o1, o2) -> {return  -o2.compareTo(o1);});
        Collections.sort(list,(o1, o2) -> {return  -o2.compareTo(o1);});
        System.out.println(list);
    }

}
