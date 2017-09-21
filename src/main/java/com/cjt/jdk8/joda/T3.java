package com.cjt.jdk8.joda;

import org.joda.time.DateTime;

public class T3 {
    public static void main(String[] args) {

        DateTime now = DateTime.now();
        System.out.println(now.monthOfYear().get()==8);

    }
}
