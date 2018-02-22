package jdk8.stream3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(6000000);
        for(int i=0; i<6000000; i++){
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
