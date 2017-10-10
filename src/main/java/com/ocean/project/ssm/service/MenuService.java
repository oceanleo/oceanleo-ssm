package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.Menu;
import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.support.log.AppLog;
import com.ocean.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/29.
 */
@AppLog("菜单业务层")
public interface MenuService {

    /**
     * 新增菜单
     */
    @AppLog("新增菜单")
    void create(Menu menu);

    /**
     * 获取菜单列表
     */
    List<MenuDto> getPageList(PageQuery query);

    /**
     * 获取当前用户的菜单
     */
    List<MenuDto> getByUserId(String userId);
}
