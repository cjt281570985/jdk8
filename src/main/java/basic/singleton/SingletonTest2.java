package basic.singleton;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 23:26
 */
public class SingletonTest2 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            MyThread2 myThread = new MyThread2();
            myThread.start();
        }


    }

}

class MyThread2 extends Thread {

    @Override
    public void run() {
        Singleton2.getInstance();
    }
}