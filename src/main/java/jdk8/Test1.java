package jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class Test1 {

    public static void main(String[] args) {
          List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

      list = list.subList(1,list.size());
        list.stream().forEach(System.out::println);


    }

  public static int get() {
    System.out.println("----------");
      return 7;
  }
}
