package com.xiong.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by gonghui on 2017/11/24.
 */
public class DateTimeUtil {
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String deteToStr(Date date, String formatStr) {
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static String dateToStr(Date date){

        return deteToStr(date, DEFAULT_FORMAT);
    }

    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }


    public static Date strToDate(String dateTimeStr){
        return strToDate(dateTimeStr, DEFAULT_FORMAT);
    }


    public static void main(String[] args) {
        Date date = new Date();
        System.out.print(DateTimeUtil.dateToStr(date));
    }

}
