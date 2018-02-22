package jdk8.stream;

import jdk8.stream2.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
public class LambdaMapReduce {
    private static List<User> userList = Arrays.asList(
            new User(1, "张三", 10,1),
            new User(2, "李四", 20, 0),
            new User(3,"王五", 30, 0),
            new User(4, "赵六", 20, 1));

    public static void main(String[] args) {
        //与stream.reduce方法不同，Stream.collect修改现存的值，而不是每处理一个元素，创建一个新值
        reduceSum();
    }

    // 注意，reduce操作每处理一个元素总是创建一个新值，
    // Stream.reduce适用于返回单个结果值的情况
    //获取所有用户的平均年龄
    private static void reduceAvg() {
        // mapToInt的pipeline后面可以是average,max,min,count,sum
        double avg = userList.parallelStream().mapToInt(User::getAge)
                .average().getAsDouble();
        System.out.println("sum: "+userList.parallelStream().mapToInt(User::getAge).sum());

        System.out.println("reduceAvg User Age: " + avg);
    }

    //获取所有用户的年龄总和
    private static void reduceSum() {
        double sum = userList.parallelStream().mapToInt(User::getAge)
                .reduce(0, (x, y) -> x + y); // 可以简写为.sum()

        System.out.println("reduceSum User Age: " + sum);
    }
}
