package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Locale;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class LocalDateUse {

    private static Logger log = LoggerFactory.getLogger(LocalDateUse.class);


    public static void main(String[] args) {
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        /**
         * LocalDate 不可变对象; 表示日期; 不表示时间; 不关联时区
         */
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalDate date = LocalDate.of(2017, 10, 1);
        log.info("year: {}", date.getYear());
        log.info("month-displayName: {}", date.getMonth().getDisplayName(TextStyle.FULL, Locale.CHINA));
        log.info("month-value: {}", date.getMonthValue());
        log.info("dayOfYear: {}", date.getDayOfYear());
        log.info("dayOfMonth: {}", date.getDayOfMonth());
        log.info("dayOfWeek-displayName: {}", date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINA));
        log.info("isLeapYear: {}", date.isLeapYear());
        log.info("chronology: {}", date.getChronology());
        log.info("era-displayName: {}", date.getEra().getDisplayName(TextStyle.FULL, Locale.CHINA));

        log.info("ChronoField year: {}", date.get(ChronoField.YEAR));
        log.info("ChronoField month: {}", date.get(ChronoField.MONTH_OF_YEAR));
        log.info("ChronoField dayOfYear: {}", date.get(ChronoField.DAY_OF_YEAR));

        /**
         * Month enum
         */
        Month month = Month.OCTOBER;
        log.info("enum Month: {}", month.getDisplayName(TextStyle.FULL, Locale.CHINA));

        /**
         * DayOfWeek enum
         */
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        log.info("enum DayOfWeek: {}", dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINA));

        /**
         * ZoneId
         */
        ZoneId.getAvailableZoneIds().stream().sorted().forEach((v) -> log.info("zone:{}", v));

        /**
         * 格式化日期
         */
        LocalDate parsedLocalDate = LocalDate.parse("2017-09-03");
        log.info("parsedLocalDate: {}", parsedLocalDate);

        /**
         * 创建副本
         */
        LocalDate newLocalDate = localDate.withYear(2000);
        log.info("newLocalDate: {}", newLocalDate);

        LocalDate newLocalDate2 = localDate.with(ChronoField.YEAR, 2001);
        log.info("newLocalDate2: {}", newLocalDate2);

        LocalDate newLocalDate3 = localDate.with(LocalDate.of(2099, 10, 1));
        log.info("newLocalDate3: {}", newLocalDate3);

        /**
         * 加减操作日期 , 创建的是副本
         */
        LocalDate localDate20110901 = LocalDate.of(2011, 9, 1);
        log.info("localDate-20110901: {}", localDate20110901);
        log.info("localDate-20110901.plusYears(5): {}", localDate20110901.plusYears(5));
        log.info("localDate-20110901: {}", localDate20110901);
        log.info("localDate-20110901.minusYears(5): {}", localDate20110901.minusYears(5));

        LocalDate localDate20110906 = localDate20110901.plus(5, ChronoUnit.DAYS);
        log.info("localDate-20110906: {}", localDate20110906);

    }
}
