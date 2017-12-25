package concurrency.first.chapter3;

public class CreateThread {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Hello...Run" + Thread.currentThread());
        }, "吉米");

        thread.start();


    }
}
