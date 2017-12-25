package concurrency.first.chapter2;

public class Bank {

    public static void main(String[] args) {

        TicketWindow t1 = new TicketWindow("一");
        t1.start();

        TicketWindow t2 = new TicketWindow("二");
        t2.start();

        TicketWindow t3 = new TicketWindow("三");
        t3.start();

    }
}
