package com.lhy.ssm.dao;

import com.lhy.ssm.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface UserDao {

    User selectById(@Param("id") String id);

    void update(@Param("userList") List<User> userList);

    void insert(User user);

    List<User> selectAll();
}
