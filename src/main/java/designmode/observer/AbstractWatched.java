package designmode.observer;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 12:09
 */
public interface AbstractWatched { //抽象主题角色

    void addWatcher(AbstractWatcher watcher);

    void removeWatcher(AbstractWatcher watcher);

    void removeAllWatchers();

    void changeStatus(); //某个状态要改变了

}
