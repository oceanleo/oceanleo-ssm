package com.oceanleo.project.ssm.support.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author haiyang.li on 2017/8/27.
 */
public abstract class StringUtils {

    public static final String EMPTY = "";

    public static final String COMMA = ",";

    public static final String DOT = ".";

    public static boolean hasText(String text) {
        return text != null && text.trim().length() > 0;
    }

    /**
     * 字符串集合转成字符串，并按指定分隔符拼接,重复的字符串不拼接
     */
    public static String join(Iterable<String> stringCollection, String separator) {
        if (stringCollection != null && hasText(separator)) {
            StringBuilder builder = new StringBuilder();
            for (String string : stringCollection) {
                if (builder.indexOf(string) == -1) {
                    builder.append(string).append(separator);
                }
            }
            if (builder.length() > 0) {
                return builder.deleteCharAt(builder.length() - 1).toString();
            }
        }
        return EMPTY;
    }

    /**
     * 字符串数组转成字符串，并按指定分隔符拼接,重复的字符串不拼接
     */
    public static String join(String[] strings, String separator) {
        List<String> stringList = Arrays.asList(strings);
        if (CollectionUtils.isNotEmpty(stringList)) {
            return join(stringList, separator);
        }
        return EMPTY;
    }
}
