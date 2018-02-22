package jdk8.joda;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/6/8.
 */
public class T2 {

    public static void main(String[] args) throws  Exception{
        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis());

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日mm分");
        String aa = localDateTime.format(dateFormatter);
        System.out.println(aa);
        System.out.println(System.currentTimeMillis());
        System.out.println(instant2);



        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime2 = instant2.atZone(zoneId).toLocalDateTime();
        System.out.println(localDateTime2);
        String aa2 = localDateTime2.format(dateFormatter);
        System.out.println(aa2);
        String format = instant2.atZone(zoneId).format(dateFormatter);
        System.out.println(instant2.atZone(zoneId).format(dateFormatter));

    }
}
