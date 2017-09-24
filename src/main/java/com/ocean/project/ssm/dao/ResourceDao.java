package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.dto.ResourceDto;
import com.ocean.project.ssm.domain.Resource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface ResourceDao {

    void insert(Resource resource);

    List<Resource> selectAll();

    List<ResourceDto> selectDtoAll();
}
