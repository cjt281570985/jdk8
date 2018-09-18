package jdk8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by Administrator on 2017/4/15.
 */
public class ConsumerTest {


    public void test(Consumer<Integer> consumer){
        System.out.println("--------------------------------");
        System.out.println(consumer instanceof Consumer); //true
        System.out.println(consumer instanceof IntConsumer); //false
        consumer.accept(100);
    }



    public static void main(String[] args) {

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        ConsumerTest consumerTest = new ConsumerTest();
        consumerTest.test(consumer);//面向对象的方式
        //consumerTest.test((Consumer)intConsumer); 此方式失败
        consumerTest.test(consumer::accept); //函数式方式
        consumerTest.test(intConsumer::accept);  //函数式方式


    }


}
