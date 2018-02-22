package jdk8.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest22 {

    public static void main(String[] args) {
        DateTime datetime = DateTime.now();
        System.out.println(datetime);

        DateTime dt=new DateTime(2012, 12, 13, 18, 23,55);
        System.out.println(dt);

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);
        System.out.println(dateTime2.plusDays(3).plusHours(3).dayOfMonth().setCopy(11));


        LocalDate date = LocalDate.now();
        LocalDate date1 = new LocalDate(2017, 5, 10);
        System.out.println(date);
        System.out.println(date.isBefore(date1));
        System.out.println(Days.daysBetween(date, date1).getDays());


    }

}
