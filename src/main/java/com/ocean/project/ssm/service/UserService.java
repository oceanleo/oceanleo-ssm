package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.support.log.AppLog;

import java.util.List;

/**
 * @author haiyang.li
 */
@AppLog("用户业务层")
public interface UserService {

    @AppLog("获取用户")
    User getById(String id);

    void update(List<User> userList);

    @AppLog("新增用户")
    void create(User user);

    @AppLog("获取所有的用户")
    List<User> getAll(UserQuery query);
}
