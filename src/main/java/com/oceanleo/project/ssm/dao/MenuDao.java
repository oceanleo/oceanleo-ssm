package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.dto.MenuDto;
import com.oceanleo.project.ssm.domain.Menu;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/25.
 */
public interface MenuDao {

    void insert(Menu menu);

    List<MenuDto> selectPageList(PageQuery query);

    List<MenuDto> selectByUserId(String userId);
}
