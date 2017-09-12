package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.support.log.Log;

import java.util.List;

/**
 * @author haiyang.li
 */
@Log("用户业务层")
public interface UserService {

    @Log("获取用户")
    User getById(UserQuery query);

    void update(List<User> userList);

    @Log("新增用户")
    void create(User user);

    List<User> getAll(UserQuery query);
}
