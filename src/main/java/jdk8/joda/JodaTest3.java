package jdk8.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest3 {

    //标准的UTF时间  2016-11-23T09:22:36.756Z
    private static Date convertUTF2Date(String utcDate){
        DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return dateTime.toDate();
    }


    private static String convertDate2UTF(Date javaDate){
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    private static String convertDate2LocalByFormat(Date javaDate, String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }




    public static void main(String[] args) {
        System.out.println(JodaTest3.convertUTF2Date("2016-11-23T09:22:36.756Z"));
        System.out.println(JodaTest3.convertDate2UTF(new Date()));
        System.out.println(JodaTest3.convertDate2LocalByFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));;

    }

}
