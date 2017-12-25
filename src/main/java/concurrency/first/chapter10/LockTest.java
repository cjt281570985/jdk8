package concurrency.first.chapter10;

import java.util.Optional;
import java.util.stream.Stream;

public class LockTest {


    public static void main(String[] args) {

        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4").forEach(name ->
                new Thread(() -> {



                }, name).start()
        );


    }


    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working...").ifPresent(System.out::println);
        Thread.sleep(1_000);
    }

}
