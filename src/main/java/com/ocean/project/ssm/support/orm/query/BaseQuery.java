package com.ocean.project.ssm.support.orm.query;

/**
 * 基本查询对象
 *
 * @author haiyang.li on 2017/9/21.
 */
public class BaseQuery {

    //数据 id
    private String id;
    //关键字
    private String keyword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
