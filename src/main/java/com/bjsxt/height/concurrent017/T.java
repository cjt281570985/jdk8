package com.bjsxt.height.concurrent017;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-19 9:13
 */
public class T
{


    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> scheduledFuture = scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("run...");
        }, 1, 3, TimeUnit.SECONDS);

        //@Scheduled(cron=""0 0 0 * * SAT)
        //spring 定时任务


    }

}
