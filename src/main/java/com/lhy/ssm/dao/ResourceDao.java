package com.lhy.ssm.dao;

import com.lhy.ssm.po.Resource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface ResourceDao {

    void insert(Resource resource);

    List<Resource> selectAll();
}
