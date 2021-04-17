package designmode.observer;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 12:43
 */
public class Client {

    //观察者模式定义了一种一对多的依赖关系,让多个观察者对象同时监听某一个主题对象.这个主题对象在状态上发生变化时,会通知所有观察者对象,让他们能够自动更新自己
    public static void main(String[] args) {

        AbstractWatched watched = new ConcreteWatched(); //被观察者

        //观察者
        AbstractWatcher watcher1 = new ConcreteWatcher();
        AbstractWatcher watcher2 = new ConcreteWatcher();
        AbstractWatcher watcher3 = new ConcreteWatcher();

        watched.addWatcher(watcher1);
        watched.addWatcher(watcher2);
        watched.addWatcher(watcher3);

        watched.changeStatus();

        watched.removeWatcher(watcher2);
        watched.changeStatus();


    }

}
