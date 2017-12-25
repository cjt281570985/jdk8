package concurrency.first.chapter4;

public class DaemonThread {



    public static void main(String[] args) throws Exception{

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" ...run");
                    Thread.sleep(30_000);
                    System.out.println(Thread.currentThread().getName()+" ...done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();

        Thread.sleep(20_000);
        System.out.println(Thread.currentThread().getName());

    }


}
