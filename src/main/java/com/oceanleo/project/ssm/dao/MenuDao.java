package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.dto.MenuDto;
import com.oceanleo.project.ssm.domain.Menu;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/25.
 */
public interface MenuDao {

    /**
     * 新增菜单
     */
    void insert(Menu menu);

    /**
     * 获取菜单列表
     */
    List<MenuDto> selectPageList(PageQuery query);

    /**
     *
     * @param userId
     * @return
     */
    List<MenuDto> selectByUserId(String userId);
}
