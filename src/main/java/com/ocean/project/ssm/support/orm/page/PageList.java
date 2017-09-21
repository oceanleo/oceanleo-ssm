package com.ocean.project.ssm.support.orm.page;

import java.util.ArrayList;

/**
 * 分页返回数据
 *
 * @author haiyang.li on 2017/9/21.
 */
public class PageList<T> extends ArrayList<T> {

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
