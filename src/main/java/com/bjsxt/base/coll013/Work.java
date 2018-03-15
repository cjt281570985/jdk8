package com.bjsxt.base.coll013;

import lombok.Data;

import java.util.Comparator;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-03-13 17:01
 */
@Data
public class Work implements Comparable<Work> {

    private int id;
    private String name;

    public Work() {

    }

    public Work(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Work work) {
        return Integer.compare(this.id,work.id);
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
