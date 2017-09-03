package com.liuzhuang.java8.dateandtime.old;

import java.util.Date;

/**
 * Created by liuzhuang on 2017/9/3.
 */
public class DateAndTime {

    public static void main(String[] args) {

        // Sun Sep 03 20:08:48 CST 2017 || Central Europe Time 中欧时间
        System.out.println(new Date());

        // http://www.cnblogs.com/peida/archive/2013/05/31/3070790.html
        System.out.println(DateUtil.parse("2017-09-03 20:22:43"));
    }


}
