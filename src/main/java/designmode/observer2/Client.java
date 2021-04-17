package designmode.observer2;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 16:53
 */
public class Client {

    public static void main(String[] args) {

        Watched watched = new Watched();

        Watcher watcher1 = new Watcher();
        Watcher2 watcher2 = new Watcher2();
        watched.addObserver(watcher2);
        watched.addObserver(watcher1);

        watched.count(3);


    }

}
