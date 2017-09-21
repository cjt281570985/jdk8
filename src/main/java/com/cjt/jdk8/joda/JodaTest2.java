package com.cjt.jdk8.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest2 {

    public static void main(String[] args) {

        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println(today.toString()); //2017-05-01T01:36:39.751+08:00
        System.out.println(today.toString("yyyy-MM-dd HH:mm:ss")); //2017-05-01
        System.out.println(tomorrow.toString("yyyy-MM-dd")); //2017-05-02
        System.out.println("-------------------");

        DateTime d1 = today.withDayOfMonth(8); //将
        System.out.println(d1); //2017-05-08T01:42:02.583+08:00
        System.out.println(d1.toString("yyyy-MM-dd")); //2017-05-08
        System.out.println(d1.toString("yyyy-MM-dd HH:mm:ss")); //2017-05-08 01:47:08

        System.out.println("-------localDate------------");
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);//2017-05-01
        System.out.println(localDate.toString());//2017-05-01
        System.out.println(localDate.toString("yyyy-MM-dd"));//2017-05-01
        System.out.println("-------------------");

        //localDate增加3个月取最大的天数值
        localDate = localDate.plusMonths(3).dayOfMonth().withMaximumValue(); //2017-08-31
        System.out.println(localDate);

        //计算2年前第2个月最后一天日期
        DateTime dt = new DateTime().minusYears(2).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue();
        System.out.println(dt.toString("yyyy-MM-dd"));

        LocalDate localDate1 = new LocalDate();
        localDate1 = localDate1.minusYears(1).plusMonths(3).withDayOfMonth(8);
        System.out.println(localDate1);

        LocalDate d11 = new LocalDate();
        LocalDate d22 = d11.plusDays(2);
        System.out.println(LocalDate.parse("2017-05-07"));
        System.out.println(d22);
        System.out.println(d22);
        //System.out.println(Days.daysBetween(d11, d22).getDays());
        System.out.println(Days.daysBetween(LocalDate.parse("2017-05-07"), new LocalDate()).getDays());

    }

}
