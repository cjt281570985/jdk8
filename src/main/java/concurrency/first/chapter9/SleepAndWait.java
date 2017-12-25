package concurrency.first.chapter9;

import java.util.stream.Stream;

public class SleepAndWait {

    private final static Object LOCK = new Object();


    private  static void m1() {

        synchronized(LOCK){
            try {
                System.out.println("now in m1.... " +Thread.currentThread().getName());
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized static void m2() {

        synchronized(LOCK){
            try {
                System.out.println("now in m2.... " +Thread.currentThread().getName());
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Stream.of("T1", "T2").forEach(name->{
            new Thread(name){
                @Override
                public void run() {
                    m2();
                }
            }.start();
        });
    }



}
