package designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 12:24
 */
public class ConcreteWatcher implements AbstractWatcher {


    @Override
    public void update() {
        System.out.println("watcher update");
    }
}
