package concurrency.juc;

import java.util.stream.IntStream;

public class Test {

  public static void main(String[] args) throws Exception {
    Thread t1 = new Thread(() -> {
      IntStream.rangeClosed(1, 1000).forEach((i)->{
        System.out.println(Thread.currentThread().getName() + " : " + i);
      });
    });
    t1.setName("t1");

    Thread t2 = new Thread(() -> {
      IntStream.rangeClosed(1, 1000).forEach((i)->{
        System.out.println(Thread.currentThread().getName() + " : " + i);
      });
    });
    t2.setName("t2");

    t2.start();
    t1.start();
    t2.join();
    t1.join();

    IntStream.rangeClosed(1, 1000).forEach((i)->{
      System.out.println(Thread.currentThread().getName() + " : " + i);
    });
  }
}
