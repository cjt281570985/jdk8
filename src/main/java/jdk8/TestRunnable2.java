package jdk8;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TestRunnable2 {

    public static void main(String[] args) {

       int a = 10;

        //在匿名类中, this代表的是类本身, 但是在Lambda表达式中, 它代表的是包含类
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                int a = 20;
                System.out.println(this);
                System.out.println(a);
            }
        };
        runnable.run();

    }

}
