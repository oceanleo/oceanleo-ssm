package com.oceanleo.project.ssm.support.orm.query;

/**
 * 分页查询对象
 *
 * @author haiyang.li on 2017/9/21.
 */
public class PageQuery extends BaseQuery implements Pageable {

    //当前页数 (默认为1)
    private int pageNumber = 1;
    //分页大小 (默认15)
    private int pageSize = 15;

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPage(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public void setLimit(int pageSize) {
        this.pageSize = pageSize;
    }
}
