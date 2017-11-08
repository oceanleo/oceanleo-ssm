package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.domain.Log;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/30.
 */
public interface LogDao {

    void insert(Log log);

    List<Log> selectAll(PageQuery query);

    void insertList(@Param("logList") List<Log> logList);
}
