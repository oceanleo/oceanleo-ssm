package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.po.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/25.
 */
public interface MenuDao {

    void insert(Menu menu);

    Menu selectById(String id);

    List<MenuDto> selectAllDto();
}
