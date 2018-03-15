package com.bjsxt.base.coll013;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-13 17:05
 */
public class TestPriorityBlockQueen {


    public static void main(String[] args) throws Exception {

        Work w1 = new Work(3, "cjt");
        Work w2 = new Work(4, "yzy");
        Work w3 = new Work(1, "lhq");
        Work w5 = new Work(2, "555");

        PriorityBlockingQueue<Work> queue = new PriorityBlockingQueue<Work>();

        queue.add(w1);
        queue.add(w2);
        queue.add(w3);

        System.out.println(queue);
        System.out.println(queue.take().getId());
        queue.add(w5);
        System.out.println(queue);


    }

}
