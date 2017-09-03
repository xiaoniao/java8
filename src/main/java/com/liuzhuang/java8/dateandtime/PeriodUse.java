package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class PeriodUse {

    private static Logger log = LoggerFactory.getLogger(PeriodUse.class);

    public static void main(String[] args) {

        /**
         * 以日为单位
         */
        log.info("ZERO: {}", Period.ZERO);
        Period period = Period.between(
                LocalDate.of(2017, 10, 1),
                LocalDate.of(2017, 11, 1));
        log.info(period.toString());
        log.info("year: {}" ,period.getYears());
        log.info("month: {}" ,period.getMonths());
        log.info("day: {}" ,period.getDays());

    }
}
