package com.oceanleo.project.ssm.support.mvc.annotation;

import java.lang.annotation.*;

/**
 * 对返回的结果数据不进行封装
 *
 * @author haiyang.li on 2017/9/21.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotUseResult {

}
