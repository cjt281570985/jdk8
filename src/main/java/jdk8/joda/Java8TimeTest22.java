package jdk8.joda;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Java8TimeTest22 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.ofYearDay(2017, 61); //2017-03-02
        System.out.println(localDate);
        LocalDate d1 = LocalDate.now();
        System.out.println(d1);



        System.out.println("----------LocalDateTime---------------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2017-05-02T15:01:33.904
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));//2017-05-02 15:03:02

        LocalDate d2 = LocalDate.of(2017, 07, 1);
        LocalDate d3 = LocalDate.of(2017, 06, 2);

        MonthDay m1 = MonthDay.of(7, 7);
        MonthDay m2 = MonthDay.of(6, 7);

        System.out.println(m1.isAfter(m2));
        System.out.println(m1.equals(m2));

        LocalDateTime dt1 = LocalDateTime.now();
        System.out.println(dt1.toLocalDate());
        System.out.println(dt1.toLocalTime());

        LocalDateTime dt2 = LocalDateTime.of(2017, 5, 2, 16, 11, 33);
        System.out.println(dt2.toLocalTime());


        System.out.println("---------合并日期和时间-------");
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
        LocalDateTime dt8 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(16, 11, 10);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1);

        System.out.println(date.with(ChronoField.MONTH_OF_YEAR, 10));;
        System.out.println(date);


    }

}
