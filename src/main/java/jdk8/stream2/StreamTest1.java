package jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/3/28
 */
public class StreamTest1 {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("hello", "world", "hello word");

    try {
      Stream<String> stream1 = list.stream();
      stream1.onClose(() -> {
        System.out.println("aaa");
      }).onClose(() -> {
        System.out.println("bbb");
      }).forEach(System.out::println);

      stream1.close();
    } catch (Exception e) {

    }
    System.out.println("-------------------");

    try (Stream<String> stream2 = list.stream()) {
      stream2.onClose(() -> {
        System.out.println("aaa");
        throw new NullPointerException("first.....");
      }).onClose(() -> {
        System.out.println("bbb");
        throw new NullPointerException("second.....");
      }).forEach(System.out::println);
    }

  }

}
