package com.cjt.jdk8.joda;

import java.time.*;
import java.util.Date;

public class DateParse {

    public static void main(String[] args) {
        System.out.println("--------------------Date to LocalDateTime------------------");

        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + localDateTime);

        System.out.println("---------------------LocalDateTime to Date-----------------");

        ZoneId zoneId1 = ZoneId.systemDefault();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        Date date1 = Date.from(zdt.toInstant());

        System.out.println("LocalDateTime = " + localDateTime);
        System.out.println("Date = " + date1);


        System.out.println("--------------------");



    }
}
