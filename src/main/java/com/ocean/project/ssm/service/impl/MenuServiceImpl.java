package com.ocean.project.ssm.service.impl;

import com.ocean.project.ssm.dao.MenuDao;
import com.ocean.project.ssm.domain.Menu;
import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.service.MenuService;
import com.ocean.project.ssm.support.orm.datasource.DataSourceContextHolder;
import com.ocean.project.ssm.support.orm.query.PageQuery;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haiyang.li on 2017/8/29.
 */
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public void create(Menu menu) {
        menuDao.insert(menu);
    }

    @Override
    public List<MenuDto> getPageList(PageQuery query) {
        return menuDao.selectPageList(query);
    }

    @Override
    public List<MenuDto> getByUserId(String userId) {
        List<MenuDto> menuDtoList = menuDao.selectByUserId(userId);


        return menuDtoList;
    }
}
