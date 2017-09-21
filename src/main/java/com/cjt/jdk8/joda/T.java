package com.cjt.jdk8.joda;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Administrator on 2017/6/8.
 */
public class T {

    public static void main(String[] args) throws  Exception{



        TemporalAdjuster NEXT_WORKDAY = w -> {
            LocalDate localDate = (LocalDate)w;
            do {
                localDate = localDate.plusDays(1);
            } while (localDate.getDayOfWeek().getValue() >= 6);
            return localDate;
        };

        TemporalAdjuster NEXT_WORKDAY2 = TemporalAdjusters.ofDateAdjuster(
                w -> {
                        LocalDate localDate = w;
                        do {
                            localDate = localDate.plusDays(1);
                        } while (localDate.getDayOfWeek().getValue() >= 6);
                        return localDate;
                    }
        );

        LocalDate backToWork = LocalDate.of(2017,6,10).with(NEXT_WORKDAY2);
        System.out.println(backToWork);

        Instant instant1 = Instant.now();
        Thread.sleep(2000);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println(duration.getNano());
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMillis());



    }
}
