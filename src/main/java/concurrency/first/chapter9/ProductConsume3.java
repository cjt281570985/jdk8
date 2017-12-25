package concurrency.first.chapter9;

import java.util.stream.Stream;

public class ProductConsume3 {

    private int index = 0;
    final private Object LOCK = new Object();
    private volatile boolean isProduct = false;

    public void product() {
        synchronized (LOCK) {
            while(isProduct) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            index++;
            System.out.println("P -> " + index);
            LOCK.notifyAll();
            isProduct = true;
        }
    }


    public void consume() {
        synchronized (LOCK) {
            while (!isProduct) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("C -> " + index);
            LOCK.notifyAll();
            isProduct = false;
        }
    }


    //此例子在多个生产者和消费者时会有问题
    //造成线程都在wait, 非死锁
    public static void main(String[] args) {

        ProductConsume3 pc = new ProductConsume3();

        Stream.of("P1", "P2","P3", "P4").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.product();
                    }
                }).start()
        );

        Stream.of("C1", "C2", "C3").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.consume();
                    }
                }).start()
        );

    }


}
