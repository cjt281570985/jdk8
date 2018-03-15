package com.bjsxt.base.conn008;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-13 9:21
 */
public class T2 {

    private static List list = new ArrayList();

    public void add(int i) {
        list.add("bjsxt_" + i);
    }

    public int size() {
        return list.size();
    }

    public List getList() {
        return list;
    }


    public static void main(String[] args) throws Exception {

        T2 t = new T2();

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 10; i++) {
                        t.add(i + 1);
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..size = " + list.size());
                        Thread.sleep(100);
                        if (list.size() == 5) {
                            System.out.println("发出通知....");
                            countDownLatch.countDown();
                            Thread.sleep(2000);
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(t.getList());
                    if (t.size() != 5) {
                        System.out.println("t2进入...");
                        countDownLatch.await();
                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "  收到中断提醒");
                    throw new Exception("666666666666");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        t1.start();


    }


}
