package concurrency.first.chapter10;

import java.util.Optional;
import java.util.stream.Stream;

public class LockTest {


    public static void main(String[] args) throws InterruptedException {

        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4").forEach(name ->
                new Thread(() -> {
                    try {
                        booleanLock.lock(10);
                        Optional.of(Thread.currentThread().getName() + " have the lock Monitor").ifPresent(System.out::println);
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Lock.TimeOutException e) {
                        Optional.of(Thread.currentThread().getName() + " Time Out").ifPresent(System.out::println);
                    } finally {
                        booleanLock.unlock();
                    }

                }, name).start()
        );

        //Thread.sleep(100);
        //booleanLock.unlock();
    }


    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working...").ifPresent(System.out::println);
        Thread.sleep(5_000);
    }

}
