package concurrency.first.chapter9;

import java.util.stream.Stream;

public class ProductConsume2 {

    private int index = 0;
    final private Object LOCK = new Object();
    private volatile boolean isProduct = false;

    public void product() {
        synchronized (LOCK) {
            if (isProduct) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                index++;
                System.out.println("P -> " + index);
                LOCK.notify();
                isProduct = true;
            }
        }
    }


    public void consume() {
        synchronized (LOCK) {
            if (isProduct) {
                System.out.println("C -> " + index);
                LOCK.notify();
                isProduct = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //此例子在多个生产者和消费者时会有问题
    //造成线程都在wait, 非死锁
    public static void main(String[] args) {

        ProductConsume2 pc = new ProductConsume2();

        Stream.of("P1", "P2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.product();
                    }
                }).start()
        );

        Stream.of("C1", "C2").forEach(n ->
                new Thread(() -> {
                    while (true) {
                        pc.consume();
                    }
                }).start()
        );

    }


}
