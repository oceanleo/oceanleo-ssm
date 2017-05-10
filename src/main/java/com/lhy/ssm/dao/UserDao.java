package com.lhy.ssm.dao;

import com.lhy.ssm.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author haiyang.li
 */
public interface UserDao {

    User selectById(@Param("id") String id);
}
