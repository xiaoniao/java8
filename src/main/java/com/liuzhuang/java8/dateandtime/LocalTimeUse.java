package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class LocalTimeUse {

    private static Logger log = LoggerFactory.getLogger(LocalTime.class);

    public static void main(String[] args) {

        log.info("MAX: {}", LocalTime.MAX);
        log.info("MIDNIGHT: {}", LocalTime.MIDNIGHT); // 午夜，半夜12点钟
        log.info("NOON: {}", LocalTime.NOON); // 中午
        log.info("MIN: {}", LocalTime.MIN);

        // 日期格式 https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        LocalTime now = LocalTime.now();
        log.info("now: {}", now);

        LocalTime time = LocalTime.of(21, 18, 0, 111);
        log.info("time: {}", time);
        log.info("hour: {}", time.getHour());
        log.info("minute: {}", time.getMinute());
        log.info("second: {}", time.getSecond());
        log.info("nano: {}", time.getNano());

        LocalTime parsedTime = LocalTime.parse("21:24:54");
        log.info("parsedTime: {}", parsedTime);
    }
}
