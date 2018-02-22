package jdk8;

/**
 * Created by Administrator on 2017/3/31.
 */
public class TestRunnable {

    public static void main(String[] args) {

       // int a = 10;

        //在匿名类中, this代表的是类本身, 但是在Lambda表达式中, 它代表的是包含类
        Runnable runnable = ()-> {

            int a = 30;

            System.out.println(a);

        };
        runnable.run();

    }

}
