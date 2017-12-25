package concurrency.first.chapter6;



public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws Exception {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("收到打断信号...");
//                    }

//                    synchronized (ThreadInterrupt.class) {
//                        try {
//                            wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }

                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(isInterrupted());
                        }
                    }

                    //System.out.println("run >> " + this.isInterrupted());
                }
            }
        };

        t.start();
        Thread.sleep(100);

        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
           public void run() {
                try {
                    Thread.sleep(100);
                    main.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());

    }


}
