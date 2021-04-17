package basic.singleton;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 23:24
 */
public class Singleton2 {

    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(singleton);
        return singleton;
    }

}
