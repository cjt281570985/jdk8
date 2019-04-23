package jdk8.joda;

import java.time.Clock;
import java.time.ZoneId;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-21 12:55
 */
public class ClockTest {

  public static void main(String[] args) throws Exception{

    //时钟提供给我们用于访问某个特定 时区的 瞬时时间、日期 和 时间的。
    Clock c1 = Clock.systemUTC(); //系统默认UTC时钟（当前瞬时时间 System.currentTimeMillis()）
    System.out.println(c1.millis()); //每次调用将返回当前瞬时时间（UTC）
    System.out.println(System.currentTimeMillis());

    Clock c2 = Clock.systemDefaultZone(); //系统默认时区时钟（当前瞬时时间）
    Clock c31 = Clock.system(ZoneId.of("Europe/Paris")); //巴黎时区
    System.out.println(c31.millis()); //每次调用将返回当前瞬时时间（UTC）


  }

}
