package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.dto.ResourceDto;
import com.oceanleo.project.ssm.domain.Resource;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface ResourceDao {

    void insert(Resource resource);

    List<Resource> selectAll();

    List<ResourceDto> selectDtoAll();
}
