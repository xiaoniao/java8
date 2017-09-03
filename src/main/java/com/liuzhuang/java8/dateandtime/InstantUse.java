package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.temporal.ChronoField;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class InstantUse {

    private static Logger log = LoggerFactory.getLogger(InstantUse.class);

    public static void main(String[] args) {

        /**
         * 整型数 从1970-01-01 00:00:00开始
         */
        Instant instant = Instant.now();
        log.info("instant: {}", instant);
        log.info("isSupported DAY_OF_YEAR: {}", instant.isSupported(ChronoField.DAY_OF_YEAR));

        Instant millInstant = Instant.ofEpochMilli(1);
        log.info(millInstant.toString());

        Instant secondInstant = Instant.ofEpochSecond(1);
        log.info(secondInstant.toString());

        secondInstant = Instant.ofEpochSecond(1, 1_000_000_000);
        log.info(secondInstant.toString());
    }
}
