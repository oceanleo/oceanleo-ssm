package com.oceanleo.project.ssm.support.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author haiyang.li on 2017/8/27.
 */
public abstract class DateUtils {

    //默认日期格式
    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    private static final String TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    //不能使用静态成员变量，线程不安全
//    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(TIME_FORMAT_STRING);
//    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);

    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();

    private static SimpleDateFormat getDateFormat() {
        SimpleDateFormat dateFormat = DATE_FORMAT_THREAD_LOCAL.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(DATE_FORMAT_STRING);
            DATE_FORMAT_THREAD_LOCAL.set(dateFormat);
        }
        return dateFormat;
    }

    private static SimpleDateFormat getTimeFormat() {
        SimpleDateFormat dateFormat = TIME_FORMAT_THREAD_LOCAL.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(TIME_FORMAT_STRING);
            TIME_FORMAT_THREAD_LOCAL.set(dateFormat);
        }
        return dateFormat;
    }

    /**
     * 格式化当前日期
     */
    public static String formatCurrentDate() {
        return getDateFormat().format(new Date());
    }

    /**
     * 格式化当前时间
     */
    public static String formatCurrentTime() {
        return getTimeFormat().format(new Date());
    }

    public static String format(Date date) {
        return date == null ? StringUtils.EMPTY : getTimeFormat().format(date);
    }

    /**
     * 格式化日期
     */
    public static String format(Date date, String format) {
        if (date != null) {
            if (StringUtils.hasText(format)) {
                if (DATE_FORMAT_STRING.equals(format)) {
                    return getDateFormat().format(date);
                } else if (TIME_FORMAT_STRING.equals(format)) {
                    return getTimeFormat().format(date);
                } else {
                    return new SimpleDateFormat(format).format(date);
                }
            } else {
                throw new IllegalArgumentException("格式为空" + " format:" + format);
            }
        }
        return StringUtils.EMPTY;
    }

    public static Date parse(String dateStr, String format) {
        AssertUtils.hasText(dateStr, "日期字符串不能为空");
        AssertUtils.hasText(format, "格式为空");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("日期字符串转日期失败", e);
        }
    }

    public static Date add(Date date, int changeValue) {
        AssertUtils.isNotNull(date, "日期不能为空");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, changeValue);
        return calendar.getTime();
    }
}
