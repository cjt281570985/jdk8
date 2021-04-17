package designmode.observer2;

import java.util.Observable;
//import java.util.Observer;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-04-10 16:40
 */
public class Watched extends Observable {

    public void count(int number) {
        for (; number >= 0; number--) {
            this.setChanged(); //需要设置 变化标识
            this.notifyObservers(number); //通知后 重置变化标识
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


/*    @Override  底层已提供, 不再需要
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }*/
}
