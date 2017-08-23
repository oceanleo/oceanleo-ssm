package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.dto.ResourceDto;
import com.ocean.project.ssm.po.Resource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface ResourceDao {

    void insert(Resource resource);

    List<Resource> selectAll();

    List<ResourceDto> selectDtoAll();

    /**
     * 根据用户名获取用户拥有的资源
     */
    List<Resource> selectByUsername(String username);
}
