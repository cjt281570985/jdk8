package concurrency.first.chapter9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


/**
 * 综合案例
 */
public class CaptureServer {

    private static LinkedList<Control> CONTROLS = new LinkedList<>();
    private static int MAX_COUNT = 5;

    public static void main(String[] args) {

        List<Thread> workers = new ArrayList<>();
        IntStream.rangeClosed(1, 10).mapToObj(i -> "M" + i).map(CaptureServer::createCaptureThread)
            .forEach(t -> {
                t.start();
                workers.add(t);
            });


        workers.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("所有线程执行线束").ifPresent(System.out::println);

    }


    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {

            Optional.of("线程 " + Thread.currentThread().getName() + " 开始.....").ifPresent(System.out::println);
            synchronized (CONTROLS){
                while (CONTROLS.size() >= MAX_COUNT) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                CONTROLS.addLast(new Control());
            }

            //并行化
            Optional.of("线程 " + Thread.currentThread().getName() + " .....工作中.....").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS) {
                Optional.of("线程 " + Thread.currentThread().getName() + " ..........结束.....").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }

        }, name);
    }

    private static class Control {

    }

}
