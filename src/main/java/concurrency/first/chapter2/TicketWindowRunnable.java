package concurrency.first.chapter2;

public class TicketWindowRunnable implements Runnable {


    private static final int MAX = 50;
    private static int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName()+ ": 当前的号码是: " + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
