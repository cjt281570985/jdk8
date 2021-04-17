package basic.singleton;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 23:24
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (singleton == null) { //此方法如果调度时 有可能会产生多个对象
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        System.out.println(singleton);
        return singleton;
    }

}
