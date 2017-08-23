package com.ocean.project.ssm.support.utils;

import com.ocean.project.ssm.support.BizException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author haiyang.li
 */
public class DateUtils {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String FORMAT_EXCEPTION = "格式为空！";
    private static final String DATE_EXCEPTION = "日期不能为空！";
    private static final String DATE_STRING_EXCEPTION = "日期字符串不能为空！";

    public static String format(Date date) {
        return FORMAT.format(date);
    }

    public static String format(Date date, String format) {
        if (StringUtils.hasText(format) && date != null) {

            return new SimpleDateFormat(format).format(date);
        }
        return StringUtils.EMPTY;
    }

    public static String formatCurrentDate() {
        return FORMAT.format(new Date());
    }

    public static String formatCurrentDate(String format) {
        if (StringUtils.hasText(format)) {
            return FORMAT.format(new Date());
        }
        return StringUtils.EMPTY;
    }

    public static Date parse(String dateStr, String format) {
        AssertUtils.hasText(dateStr,DATE_STRING_EXCEPTION);
        AssertUtils.hasText(format,FORMAT_EXCEPTION);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new BizException("日期字符串转日期失败！");
        }
    }

    public static Date add(Date date,int changeValue){
        AssertUtils.isNotNull(date,DATE_EXCEPTION);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, changeValue);
        return calendar.getTime();
    }
}
