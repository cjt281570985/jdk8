package jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/3/28
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello word");

        //压制异常,  同一个异常不会压制
        NullPointerException exception = new NullPointerException("my exception");
        try (Stream<String> stream = list.stream()){
            stream.onClose(() -> {
                System.out.println("aaa");

                //throw new NullPointerException("first exception");
                throw exception;
            }).onClose(() -> {
                System.out.println("bbb");

                //throw new NullPointerException("second exception");
                throw exception;
            }).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
