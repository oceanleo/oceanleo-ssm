package com.lhy.ssm.dao;

import com.lhy.ssm.po.Role;
import com.lhy.ssm.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface RoleDao {

    void insert(Role role);
}
