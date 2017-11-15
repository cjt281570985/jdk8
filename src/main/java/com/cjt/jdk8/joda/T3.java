package com.cjt.jdk8.joda;

import org.joda.time.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class T3 {
    public static void main(String[] args) throws Exception{

        Instant instant = Instant.now();
        System.out.println(instant); //2017-11-09T09:30:52.331Z

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2017-11-09T17:31:47.164+08:00

        System.out.println(System.currentTimeMillis());//1510220012283
        System.out.println(instant.toEpochMilli());    //1510220012178
        System.out.println(instant.getEpochSecond());  //1510220012

        //Duration: 计算2个"时间"之间的间隔
        //Period: 计算2个"日期"之间的间隔

        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration);//PT1S
        System.out.println(duration.getSeconds());//1
        System.out.println(duration.toMillis());//1001

        System.out.println("--------------------------------");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        Duration duration1 = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration1.toMillis());//1001

        System.out.println("--------------------------------");
        LocalDate ld1 = LocalDate.of(2016, 8, 25);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


        System.out.println("-------------TemporalAdjuster-------------------");
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime dt = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(dt);

        //下一个工作日
        TemporalAdjuster nextWorkDay = w -> {
            LocalDateTime date = (LocalDateTime)w;
            do {
                date = date.plusDays(1);
            } while (date.getDayOfWeek().getValue() >= 6);
            return date;
        };

        LocalDateTime dt2 = ldt.with(nextWorkDay);
        System.out.println(dt2);

        //格式化
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        String format = dt2.format(dtf);
        System.out.println(format);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2017-05-02T15:01:33.904
        String date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date);//2017-05-02 15:03:02

        LocalDateTime newDate = localDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(newDate);

        //ZonedDate  ZonedTime ZonedDateTime
        Set<String> set = ZoneId.getAvailableZoneIds();
        //set.forEach(System.out::println);
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);


    }
}
