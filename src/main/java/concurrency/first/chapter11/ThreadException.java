package concurrency.first.chapter11;

public class ThreadException {

    private final static int A = 10;
    private final static int B = 0;


    //捕获异常
    public static void main(String[] args) {

        Thread t = new Thread(()->{
            try {
                Thread.sleep(2000);
                int result = A/B;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(e);
            System.out.println(thread);
        });

        t.start();


    }
}
