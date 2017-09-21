package com.cjt.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


/**
 * Created by Administrator on 2017/3/22.
 */
public class MySetCollector3333<T> implements Collector<T, Set<T>, Map<T, T>> {
    int time = 0;

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier........");
        return () -> {
            time ++;
            System.out.println("---------------容器" + time + "-----------------");
            return new HashSet<T>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator........");
        return (set, item)->{
            set.add(item);
            System.out.println("accumulator: " + set + ", " + Thread.currentThread().getName());
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner........");
        return (set1, set2) -> {
            System.out.println("set1: " + set1);
            System.out.println("set2: " + set2);
            set1.addAll(set2);
            System.out.println("combiner...... ....................合并结果..............");
            return set1;
        };

    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher........");
        return set -> {
            Map<T, T> map = new TreeMap<T, T>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics........");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT,  Characteristics.UNORDERED));
    }

    public static void main(String[] args) {



        for (int i=0;i<1;i++) {
            List<String> list = Arrays.asList("hello","zzz", "world", "welcome", "world");
            Set<String> set = new HashSet<>();
            set.addAll(list);
            Map<String, String> collect = set.stream().parallel().collect(new MySetCollector3333<>());
            System.out.println(collect);
        }


    }







}
