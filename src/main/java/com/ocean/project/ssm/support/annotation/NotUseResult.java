package com.ocean.project.ssm.support.annotation;

import java.lang.annotation.*;

/**
 * 控制层不需要使用 Result 封装返回
 *
 * @author haiyang.li on 2017/8/24.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotUseResult {

}
