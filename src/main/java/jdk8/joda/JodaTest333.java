package jdk8.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;


/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest333 {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println(LocalTime.now().getHourOfDay()<10);

        DateTime dateTime = DateTime.parse("2017-06-22 10:10:10", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse = LocalDateTime.parse("2017-06-28 10:10:10", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.now();
        //2017-06-22T10:10:10.000+08:00
        System.out.println(parse);
        System.out.println(now);
        System.out.println(now.isAfter(parse));
        long a = 1_00L;
        System.out.println(a);



    }

}
