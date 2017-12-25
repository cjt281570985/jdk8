package concurrency.first.chapter10;

import java.util.ArrayList;
import java.util.Collection;

public class BooleanLock implements Lock {

    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public void lock() throws InterruptedException {

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeOutException {

    }

    @Override
    public void unlock() {

    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return null;
    }

    @Override
    public int getBlockedSize() {
        return 0;
    }
}
