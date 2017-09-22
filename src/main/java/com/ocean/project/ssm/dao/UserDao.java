package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.domain.User;
import com.ocean.project.ssm.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserDao {

    /**
     * 根据用户id获取用户
     */
    User selectById(String id);

    /**
     * 修改用户信息
     */
    void updateList(@Param("userList") List<User> userList);

    /**
     * 添加用户
     */
    void insert(User user);

    /**
     * 获取所有的用户
     */
    List<User> selectAll(UserQuery query);

    /**
     * 用户名获取用户信息
     */
    User selectByUsername(String username);
}
