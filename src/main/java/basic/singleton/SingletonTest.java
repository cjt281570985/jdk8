package basic.singleton;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 23:26
 */
public class SingletonTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }


    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}