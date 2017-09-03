package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class LocalDateTimeUse {

    private static Logger log = LoggerFactory.getLogger(LocalDateTimeUse.class);

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("localDateTime: {}", localDateTime);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = date.atTime(time);
        log.info("dateTime: {}", dateTime);

        LocalDateTime timeDate = time.atDate(date);
        log.info("timeDate: {}", timeDate);
    }
}
