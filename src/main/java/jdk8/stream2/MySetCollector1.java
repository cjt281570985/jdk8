package jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Administrator on 2017/3/22.
 */
public class MySetCollector1<T> implements Collector<T, Set<T>, Map<T,T>> {

    //ctrl+i  重写方法
    private static int time = 0;

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoke!");
        //return HashSet<T>::new;
        return () -> {
            time ++;
            System.out.println("---------------容器" + time + "-----------------");
            return new HashSet<T>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoke!");

        return (set, item)->{
            set.add(item);
            System.out.println("accumulator: " + set + ", " + Thread.currentThread().getName());
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoke!");


        return (set1, set2) -> {
            System.out.println("set1: " + set1);
            System.out.println("set2: " + set2);
            set1.addAll(set2);
            System.out.println("combiner..........................合并结果..............");
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoke!.........");


       return set -> {
            Map<T, T> map = new TreeMap<T, T>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoke!");

        //Characteristics.CONCURRENT 有此值 只有唯一的一个结果容器,即combiner不需要合并(多个线程操作一个结果容器)
        //如果只有parallelStream 没Characteristics.CONCURRENT 多个线程操作多个结果容器, 多个部分结果需要合并
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,  Characteristics.CONCURRENT));
    }


    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "welcome", "world" ,"a" ,"k","b","sdsd","32sda","dsfqqww","00pp");

        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);

        for(int i=0;i<1;i++){
            //parallelStream 和 Characteristics.CONCURRENT 同时使用 可能 会发生异常 Caused by: java.util.ConcurrentModificationException
            // System.out.println("accumulator: " + set + ", " + Thread.currentThread().getName());
            //上面的输出导致异常, 即不能不能边修改边遍历
            Map<String, String> map = set.parallelStream().sequential().parallel().collect(new MySetCollector1<>());
            System.out.println(map);
        }


        System.out.println("电脑线程数: " + Runtime.getRuntime().availableProcessors());

    }




}
