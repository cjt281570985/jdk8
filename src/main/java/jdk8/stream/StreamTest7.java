package jdk8.stream;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/1.
 */
public class StreamTest7 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(5000000);
        for(int i=0; i<5000000; i++){
            list.add((UUID.randomUUID().toString()));
        }

        System.out.println("开始排序...");
        long start = System.nanoTime();
        //并行流的使用
        list.parallelStream().sorted().count();
        long time = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        System.out.println("排序用时: " + time);
    }
}
