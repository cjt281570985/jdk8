package com.bjsxt.base.coll013.my;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-13 17:24
 */

@Data
public class Man implements Delayed
{

    private String name;
    //身份证
    private String id;
    //截止时间
    private long endTime;
    //定义时间工具类
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public Man() {

    }

    public Man(String name, String id, long endTime, TimeUnit timeUnit) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
        this.timeUnit = timeUnit;
    }

    /**
     * 用来判断是否到了截止时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    /**
     * 相互批较排序用
     */
    @Override
    public int compareTo(Delayed delayed) {
        Man man = (Man)delayed;

        return 0;
    }
}
