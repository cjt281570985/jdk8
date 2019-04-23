package jdk8.joda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-19 23:22
 */
public class TemporalAdjusterTest {

  public static void main(String[] args) {

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //TODO 获取当前时间
    LocalDate inputDate = LocalDate.now();
    //TODO 当天开始
    LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    //TODO 当天结束
    LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    String todayStartTime = today_start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    String todayEndTime = today_end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    //TODO 本周开始时间
    // 计算周开始时间 = 当前日期 - （当前日期是周几 - 周一）的日期差
    TemporalAdjuster FIRST_OF_WEEK = TemporalAdjusters
        .ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
    String weekStart = df.format(inputDate.with(FIRST_OF_WEEK));
    //TODO 本周结束时间
    TemporalAdjuster LAST_OF_WEEK =
        TemporalAdjusters.ofDateAdjuster(localDate -> localDate
            .plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
    String weekEnd = df.format(inputDate.with(LAST_OF_WEEK));
    //TODO 本月的第一天
    String monthStart = df.format(LocalDate.of(inputDate.getYear(), inputDate.getMonth(), 1));
    //TODO 本月的最后一天
    String monthEnd = df.format(inputDate.with(TemporalAdjusters.lastDayOfMonth()));

    System.out.println(todayStartTime);
    System.out.println(todayEndTime);
    System.out.println(weekStart);
    System.out.println(weekEnd);
    System.out.println(monthStart);
    System.out.println(monthEnd);

    System.out.println("--------------------------------");
    System.out.println(currentWeekFirstDay());
    System.out.println(currentWeekLastDay());
    System.out.println(firstDayOfCurrentMonth());
    System.out.println(lastDayOfCurrentMonth());


  }


  /**
   * 获取某日期当前周的周一
   * @param date
   * @return
   */
  public static LocalDate getWeekFirstDay(LocalDate date) {
    TemporalAdjuster firstOfWeek = TemporalAdjusters
        .ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
    return date.with(firstOfWeek);
  }
  public static LocalDate currentWeekFirstDay() {
    return getWeekFirstDay(LocalDate.now());
  }

  /**
   * 获取某日期当前周的周日
   * @param date
   * @return
   */
  public static LocalDate getWeekLastDay(LocalDate date) {
    TemporalAdjuster lastOfWeek =
        TemporalAdjusters.ofDateAdjuster(localDate -> localDate
            .plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
    return date.with(lastOfWeek);
  }

  public static LocalDate currentWeekLastDay() {
    return getWeekLastDay(LocalDate.now());
  }

  /**
   * 获取某月第一天
   * @return
   */
  public static LocalDate firstDayOfMonth(LocalDate localDate) {
    return localDate.withDayOfMonth(1);
  }
  public static LocalDate firstDayOfCurrentMonth() {
    return firstDayOfMonth(LocalDate.now());
  }

  /**
   * 获取某月最后一天
   * @return
   */
  public static LocalDate lastDayOfMonth(LocalDate localDate) {
    return localDate.with(TemporalAdjusters.lastDayOfMonth());
  }
  public static LocalDate lastDayOfCurrentMonth() {
    return lastDayOfMonth(LocalDate.now());
  }
}
