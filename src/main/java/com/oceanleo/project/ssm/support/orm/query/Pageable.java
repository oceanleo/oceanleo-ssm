package com.oceanleo.project.ssm.support.orm.query;

/**
 * 分页接口支持
 *
 * @author haiyang.li on 2017/9/21.
 */
public interface Pageable {

    //当前页
    int getPageNumber();
    //分页大小
    int getPageSize();
}
