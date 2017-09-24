package com.ocean.project.ssm.dao;

import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.domain.Menu;
import com.ocean.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/25.
 */
public interface MenuDao {

    void insert(Menu menu);

    List<MenuDto> selectAllDto();

    List<MenuDto> selectPageList(PageQuery query);
}
