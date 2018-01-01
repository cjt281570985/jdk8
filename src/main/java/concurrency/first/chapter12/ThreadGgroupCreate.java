package concurrency.first.chapter12;

import java.util.Arrays;

public class ThreadGgroupCreate {


    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup());

        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1"){
            @Override
            public void run() {
                while (true) {
                    try {
//                        System.out.println(getThreadGroup().getName());
//                        System.out.println(getThreadGroup().getParent());
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2, "T2"){
            @Override
            public void run() {
                System.out.println("tg2.getParentName(): " +tg2.getParent());
                System.out.println("tg1.getName(): " +tg1.getName());
                Thread[] threads = new Thread[tg1.activeCount()];
                tg1.enumerate(threads);

                System.out.println("---threads---start-");
                Arrays.asList(threads).forEach(System.out::println);
                System.out.println("---threads--end--");
            }
        };

        t2.start();
//
        //System.out.println(t1.getThreadGroup());


    }
}
