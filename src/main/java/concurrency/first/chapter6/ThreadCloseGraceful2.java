package concurrency.first.chapter6;

public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
               /* try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }*/
                System.out.println("打断线程....");
                if (Thread.interrupted()) {
                    System.out.println("线程....XXXX被打断了...");
                    break;
                }

            }
        }


    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
        System.out.println("打断线程....");
    }

}
