package concurrency.first.chapter12;

import java.util.Arrays;
import java.util.TreeMap;

public class ThreadGgroupAPI {


    public static void main(String[] args) {


        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(8_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.setDaemon(true);
        t1.start();

        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        Thread t2 = new Thread(tg2, "t2") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t2.start();

        System.out.println(tg1.activeCount());
        System.out.println(tg1.activeGroupCount());
        //tg1.checkAccess();
        //tg1.destroy();

        Thread[] threads = new Thread[tg1.activeCount()];
        tg1.enumerate(threads);

        System.out.println("---threads---start-");
        Arrays.asList(threads).forEach(System.out::println);
        System.out.println("---threads--end--");

        threads = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(threads, false);
        System.out.println("------AA------");
        Arrays.asList(threads).forEach(System.out::println);
        System.out.println("------AA------");

        //tg1.interrupt();

    }
}
