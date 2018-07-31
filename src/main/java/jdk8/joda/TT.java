package jdk8.joda;

import java.time.LocalDate;
import java.time.Period;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-05-18 16:52
 */
public class TT {


  public static void main(String[] args) {




    LocalDate start = LocalDate.of(2016, 11, 12);
    LocalDate now = LocalDate.now();
    System.out.println(now);


    Period between = Period.between(start, now);


    int months = between.getMonths();
    int years = between.getYears();
    int days = between.getDays();
    System.out.println(years);
    System.out.println(months);
    System.out.println(days);

    System.out.println("--------------------------------");
    if (years == 0) {
      System.out.println(years + 1);
    } else if (months >= 6) {
      System.out.println(years + 1);
    } else {
      System.out.println(years);
    }

    int a = 3;
    a +=1;
    System.out.println(a);





  }

}
