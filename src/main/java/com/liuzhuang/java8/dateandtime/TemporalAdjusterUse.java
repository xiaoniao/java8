package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class TemporalAdjusterUse {

    private static Logger log = LoggerFactory.getLogger(TemporalAdjusterUse.class);

    public static void main(String[] args) {

        /**
         * 经过定制化的静态方法 创建的都是副本
         */

        LocalDate now = LocalDate.now();

        log.info("firstDayOfMonth: {}", now.with(TemporalAdjusters.firstDayOfMonth()));
        log.info("firstDayOfYear: {}", now.with(TemporalAdjusters.firstDayOfYear()));
        log.info("firstDayOfNextMonth: {}", now.with(TemporalAdjusters.firstDayOfNextMonth()));
        log.info("firstDayOfNextYear: {}", now.with(TemporalAdjusters.firstDayOfNextYear()));
        log.info("nextWorkingDay: {}", now.with(new NextWorkingDay()));
    }

    /**
     * 自定义日期转换
     */
    public static class NextWorkingDay implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY)
                dayToAdd =  3;
            else if (dayOfWeek == DayOfWeek.SATURDAY)
                dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }
}
