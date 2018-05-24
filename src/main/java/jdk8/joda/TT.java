package jdk8.joda;

import org.joda.time.LocalDateTime;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-05-18 16:52
 */
public class TT {


  public static void main(String[] args) {

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now.getMonthOfYear());

    System.out.println(now.getDayOfMonth());
    LocalDateTime localDateTime = now.plusDays(15);
    System.out.println(localDateTime);


  }

}
