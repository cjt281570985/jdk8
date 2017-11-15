package com.cjt.jdk8.stream3;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<10; i++){
            //putIfAbsent使得我们不用写是否为null值的检测语句；
            map.putIfAbsent(i, "val_"+i);
        }

        //-------1------maps不支持流。然而现在maps包括了许多新的非常有用的方法用于执行通用任务:
        //forEach使用consumer来对map中的每个元素进行操作,执行通用任务。
        map.forEach((key, val)-> System.out.println(key+" = " +val));

        //----------2-------------------使用功能性函数在map里执行代码：
        //将key为3对应的值(val_3)改为  "val_3"+3*10 = val_330
        //如果指定键的值是存在的，并且非null，则尝试计算给定键及其当前映射值的新映射
        //如果函数返回@code null，映射就会被删除
        map.computeIfPresent(3, (key, val) -> val + key * 10);
        System.out.println("map.get(3): " + map.get(3));

        //将key为9对应的值(val_9)改为  null
        map.computeIfPresent(9, (key, val) -> null);


        //将key为23对应的值(null)改为  "val_23"
        map.computeIfAbsent(23, key -> key + "_val");
        System.out.println(map.get(23));

        map.put(5, null);
        map.computeIfAbsent(5, key -> "555");
        System.out.println(map.get(5));

        System.out.println(map.remove(1, "val_1"));//true
        System.out.println(map.get(1));//null

        //如果指定的键还没有与某个值相关联与null关联，将其与给定的非空值关联起来。
        //否则，用给定的结果替换相关的值重新映射函数，如果结果是@code null，就删除它
        map.merge(5, "val1", (oldVal, newVal) -> oldVal + "--" + newVal);
        System.out.println(map.get(5));

        map.put(3, null);
        System.out.println("map.containsKey(3): "+map.containsKey(3));
        map.merge(3, "val3", (oldVal, newVal) -> oldVal + "--" + newVal);
        System.out.println(map.get(3));


        System.out.println(map.getOrDefault(11, "no find"));

    }
}
