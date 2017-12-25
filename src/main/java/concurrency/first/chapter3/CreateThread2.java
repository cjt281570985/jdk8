package concurrency.first.chapter3;

import java.util.Arrays;

public class CreateThread2 {

    public static void main(String[] args) {

        Thread t = new Thread();
        t.start();
        System.out.println(t.getThreadGroup());//java.lang.ThreadGroup[name=main,maxpri=10]

        System.out.println(Thread.currentThread().getName());//main
        System.out.println(Thread.currentThread().getThreadGroup().getName());//main

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());


        Thread[] threads = new Thread[threadGroup.activeCount()];

        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);



    }
}
