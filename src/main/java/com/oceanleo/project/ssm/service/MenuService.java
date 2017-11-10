package com.oceanleo.project.ssm.service;

import com.oceanleo.project.ssm.domain.Menu;
import com.oceanleo.project.ssm.dto.MenuDto;
import com.oceanleo.project.ssm.support.log.AppLog;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/29.
 */
@AppLog("菜单业务层")
public interface MenuService {

    @AppLog("新增菜单")
    void create(Menu menu);

    @AppLog("获取菜单列表")
    List<MenuDto> getPageList(PageQuery query);

    @AppLog("通过用户id获取菜单")
    List<MenuDto> getByUserId(String userId);
}
