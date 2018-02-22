package jdk8.joda;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public class JodaTest7 {

    public static void main(String[] args) {
        DateTime datetime = DateTime.now();
        System.out.println(datetime);

        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = LocalTime.parse("09:50:00.000");
        System.out.println(localTime);
        System.out.println(localTime2);
        System.out.println(localTime2.isAfter(localTime));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        boolean before = datetime.isBefore(DateTime.parse("2017-08-01 09:50:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(before);

        List<Integer> list = new ArrayList<>(3);
        for (int i = 0; i <9 ; i++) {

            if(i==5){
                list.add(0, i);
            }
            if(i==7){
                list.add(1, i);
            }
            if(i==2){
                list.add(2, i);
            }

        }
        System.out.println(list.size());
        System.out.println(list);


    }

}
