package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import com.ocean.project.ssm.support.log.AppLog;
import com.ocean.project.ssm.support.security.po.CurrentUser;

import java.util.List;

/**
 * @author haiyang.li
 */
@AppLog("用户业务层")
public interface UserService {

    User getById(String id);

    @AppLog("批量修改用户信息")
    void update(List<User> userList);

    @AppLog("新增用户")
    void create(User user);

    List<User> getAll(UserQuery query);

    @AppLog("修改当前用户密码")
    void updatePassword(CurrentUser currentUser, String oldPassword, String newPassword);
}