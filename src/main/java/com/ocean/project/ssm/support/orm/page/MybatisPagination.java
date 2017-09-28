package com.ocean.project.ssm.support.orm.page;

import com.ocean.project.ssm.support.orm.query.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author haiyang.li on 2017/9/21.
 */
public class MybatisPagination {

    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>();

    private Pagination pagination;

    public MybatisPagination(Pageable pageable) {
        pagination = new Pagination(pageable);
    }

    public int getStartNum(){
        return this.pagination.getStartNum();
    }

    public int getEndNum(){
        return this.pagination.getEndNum();
    }

    public int getPageSize(){
        return this.pagination.getPageSize();
    }

    public Map<String, Object> getParams(){
        return this.pagination.getParams();
    }

    public static boolean isPagingResult() {
        return THREAD_LOCAL.get() != null;
    }

    public static void setTotal(Integer total){
        THREAD_LOCAL.set(total);
    }

    public static <T> PageList<T> toPageList(List<T> list){
        PageList<T> pageList = new PageList<T>();
        pageList.setTotal(THREAD_LOCAL.get());
        pageList.addAll(list);
        THREAD_LOCAL.remove();
        return pageList;
    }
}
