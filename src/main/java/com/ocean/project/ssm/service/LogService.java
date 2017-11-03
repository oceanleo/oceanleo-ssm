package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.Log;
import com.ocean.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/9/30.
 */
public interface LogService {
    
    void create(Log log);

    List<Log> findAll(PageQuery query);

    void createList(List<Log> logList);
}
