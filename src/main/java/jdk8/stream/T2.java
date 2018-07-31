package jdk8.stream;

import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/9.
 */
public class T2 {
    public static void main(String[] args) {
        Optional<String> xxx = Stream.of("bbb", "a232", "xxx", "nnn").filter(a -> a.equals("xxx2")).map(b -> b + "000").findFirst();
        System.out.println(xxx.orElse("999"));


//        String xxx2 = Stream.of("bbb", "a232", "xxx", "nnn").filter(a -> a.equals("xxx")).map(b -> b + "000").toString();
//        System.out.println(xxx2);
    }
}
