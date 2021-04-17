package designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 12:24
 */
public class ConcreteWatched implements  AbstractWatched {

    private List<AbstractWatcher> list = new ArrayList();

    @Override
    public void addWatcher(AbstractWatcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(AbstractWatcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void removeAllWatchers() {
        list.clear();
    }

    @Override
    public void changeStatus() {
        System.out.println("changeStatus...");
        //通知所有观察者改变自己
        list.forEach(watcher -> {
            watcher.update(); //通知所有的观察者, 让他们自动更新
        });
    }
}
