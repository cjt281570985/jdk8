package designmode.observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 16:52
 */
public class Watcher2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updated...222");
    }
}
