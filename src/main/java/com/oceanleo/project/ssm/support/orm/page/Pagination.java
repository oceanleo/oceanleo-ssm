package com.oceanleo.project.ssm.support.orm.page;

import com.oceanleo.project.ssm.support.orm.query.Pageable;
import com.oceanleo.project.ssm.support.utils.BeanUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 分页支持
 *
 * @author haiyang.li on 2017/9/21.
 */
public class Pagination {

    //当前页面条数
    private int pageSize;
    //分页开始
    private int startNum;
    //分页结束
    private int endNum;
    //参数
    private Map<String, Object> params = new HashMap<String, Object>();

    public Pagination(Pageable pageable) {
        this.createPageInfo(pageable);
        this.pageSize = pageable.getPageSize();
        this.params = createParamsMap(pageable);
    }

    private Map<String, Object> createParamsMap(Object pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Target bean can not be null!");
        }
        if (pageable instanceof Map) {
            return (Map<String, Object>) pageable;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        List<Field> fieldList = new ArrayList<Field>();
        Class clazz = pageable.getClass();
        do {
            Field[] declaredFields = clazz.getDeclaredFields();
            fieldList.addAll(Arrays.asList(declaredFields));
            clazz = clazz.getSuperclass();
        } while (!clazz.equals(Object.class));
        for (Field field : fieldList) {
            String fieldName = field.getName();
            map.put(fieldName, BeanUtils.getFieldValue(pageable, fieldName));
        }
        return map;
    }

    private void createPageInfo(Pageable pageable) {
        this.startNum = pageable.getPageNumber() > 0 ? (pageable.getPageNumber() - 1) * pageable.getPageSize() : 0;
        this.endNum = this.startNum + pageable.getPageSize() * (pageable.getPageNumber() > 0 ? 1 : 0);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }
}
