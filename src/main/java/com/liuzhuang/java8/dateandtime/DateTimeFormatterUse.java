package com.liuzhuang.java8.dateandtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by liuzhuang on 2017/9/4.
 */
public class DateTimeFormatterUse {

    private static Logger log = LoggerFactory.getLogger(DateTimeFormatterUse.class);


    public static void main(String[] args) {
        /*LocalDate localDate = LocalDate.parse("2017-09-04 00:19:38");
        log.info("{}", localDate);*/

        /**
         * 日期格式化
         */

        String strLocalDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        log.info("{}", strLocalDate);

        LocalDate localDate = LocalDate.parse(strLocalDate, DateTimeFormatter.BASIC_ISO_DATE);
        log.info("{}", localDate);

        DateTimeFormatter.ofPattern("yyyy MM dd");
    }

}
