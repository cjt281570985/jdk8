package com.cjt.jdk8.joda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Java8TimeTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + " ," + localDate.getMonthValue() + " ," + localDate.getDayOfMonth());

        System.out.println("-----------");

        LocalDate LocalDate2 = LocalDate.of(2017, 5, 2);
        System.out.println(LocalDate2);

        System.out.println("------比较月日-----");

        //比较月日
        LocalDate localDate3 = LocalDate.of(2017, 5, 22);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2016, 5, 22));

        System.out.println(monthDay.equals(monthDay1));
        System.out.println(monthDay);
        System.out.println(monthDay1);

        System.out.println("-----LocalTime------");
        LocalTime localTime = LocalTime.now(); //14:18:01.322
        System.out.println(localTime);

        //时间加2小时11分钟
        LocalTime localTime2 = localTime.plusHours(2).plusMinutes(11);
        System.out.println(localTime2);

        //增加2周后的日期
        LocalDate now = LocalDate.now();
        //now = now.plusWeeks(2);
        now = now.plus(2, ChronoUnit.WEEKS);
        System.out.println(now);

        now = now.minusMonths(3);
        System.out.println(now);


        System.out.println("------Clock------");
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.of(2017, 5, 30);
        System.out.println(d1.isAfter(d2));
        System.out.println(d1.isBefore(d2));
        System.out.println(d1.equals(d2));

        //时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        //TreeSet<String> treeSet = new TreeSet<>(set);
        TreeSet<String> treeSet = new TreeSet<String>() {
            {
                addAll(set);
            }
        };
        System.out.println(treeSet);
        //treeSet.stream().forEach(System.out::println);


        System.out.println("----------LocalDateTime---------------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);


        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime localDateTime2 = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(localDateTime2);


        //年月
        System.out.println("-------年月-------");
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.getMonthValue());
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());
        System.out.println("-------");
        YearMonth yearMonth1 = YearMonth.of(2016, 6);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfYear());
        System.out.println(yearMonth1.isLeapYear());
        System.out.println(yearMonth1.isAfter(YearMonth.of(2016, 2)));

        //Period 周期
        System.out.println("----Period-------");
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,6,6);
        Period period = Period.between(date1, date2);
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.ofWeeks(3));

        System.out.println(Instant.now()); //2017-04-29T18:47:37.243Z


        Date date = new Date();
        LocalDate localDate8 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("localDate = " + localDate8);

    }

}
