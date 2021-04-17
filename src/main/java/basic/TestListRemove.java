package basic;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-03-27 10:31
 */
public class TestListRemove {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
            if ("bb".equals(next)) {
                System.out.println("del: " + next);
                //不能用原列表遍历删除, 用iterator
                it.remove();
            }
        }
        System.out.println("--------------------------------");

        System.out.println(list);
        System.out.println("----------------222----------------");


        List<String> list2 = new ArrayList<>();
        list2.add("a2323");
        list2.add("badsfasdas");
        list2.add("cc223");
        list2.add("dds");
        list2.add("3ddsdfds");
        list2.add("32");
        //不能用原列表遍历删除, 用iterator
        list2.removeIf(s -> s.length() > 3);
        //不能用下面遍历删除, 会出异常
//        for (String s : list2) {
//            if (s.length() > 3) {
//                list2.remove(s);
//            }
//        }
        System.out.println(list2);
        System.out.println("----------------3333333----------------");

        //Arrays.asList  这个不能删除
//        List<String> strings = Arrays.asList("111", "2222", "3333", "44444", "555555", "000", "777rw");
//        strings.removeIf(s -> s.length() >3);
//        System.out.println(strings);
    }

}
