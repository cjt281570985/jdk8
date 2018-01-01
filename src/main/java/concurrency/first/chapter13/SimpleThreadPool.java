package concurrency.first.chapter13;

import java.util.LinkedList;

public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static  ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    public SimpleThreadPool() {
        this.size = DEFAULT_SIZE;
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init() {

    }

    private void createWorkTask(String name) {

    }

    private enum TaskState {
        FREE,RUNNING, BLOCKED,DEAD
    }


    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState(){
            return this.taskState;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState =  TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }

                    Runnable runnable = TASK_QUEUE.removeFirst();
                    if (runnable != null) {
                        taskState = TaskState.RUNNING;
                        runnable.run();
                        taskState = TaskState.FREE;
                    }
                }
            }
        }

        public void close(){
            this.taskState = TaskState.DEAD;
        }


    }


}
