package com.oceanleo.project.ssm.support.log;

import java.lang.annotation.*;

/**
 * 日志记录
 *
 * @author haiyang.li on 2017/8/30.
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppLog {

    String value();
}
