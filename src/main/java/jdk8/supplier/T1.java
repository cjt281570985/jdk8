package jdk8.supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-02 21:26
 */
public class T1 {


  public static void main(String[] args) {

    List<Integer> names = new ArrayList<>();
    names.add(3);
    names.add(13);
    names.add(2);
    names.add(6);


    System.out.println(names.removeIf(a -> a > 35));

    Stream.generate(Math::random).limit(10).forEach(System.out::println);



  }

}
