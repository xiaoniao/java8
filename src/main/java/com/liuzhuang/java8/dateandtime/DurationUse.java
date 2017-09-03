package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class DurationUse {

    private static Logger log = LoggerFactory.getLogger(DurationUse.class);

    public static void main(String[] args) {

        /**
         * 秒 毫秒
         */

        LocalTime time1 = LocalTime.of(22, 41, 0, 200);
        LocalTime time2 = LocalTime.of(23, 42, 10, 1000);

        Duration timeDuration = Duration.between(time1, time2);
        log.info("{}", timeDuration);
        log.info("second: {}", timeDuration.getSeconds());
        log.info("nano: {}", timeDuration.getNano());

        // UnsupportedTemporalTypeException 只能比较秒和纳秒
//        Duration dateDuration = Duration.between(
//                LocalDate.of(2017, 10, 1),
//                LocalDate.of(2017, 10, 2));

        Duration dateTimeDuration = Duration.between(
                LocalDateTime.of(2017, 10, 1, 23, 10, 0),
                LocalDateTime.of(2017, 11, 1, 23, 10, 0)
        );
        log.info("{}", dateTimeDuration);

        Duration duration = Duration.ofDays(3);
        log.info("{}", duration);

    }
}
