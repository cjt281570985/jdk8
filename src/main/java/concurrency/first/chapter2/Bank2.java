package concurrency.first.chapter2;

public class Bank2 {

    public static void main(String[] args) {

        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(ticketWindowRunnable, "1号窗口");
        Thread windowThread2 = new Thread(ticketWindowRunnable, "2号窗口");
        Thread windowThread3 = new Thread(ticketWindowRunnable, "3号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();

    }
}
