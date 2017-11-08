package com.oceanleo.project.ssm.service.impl;

import com.oceanleo.project.ssm.dao.MenuDao;
import com.oceanleo.project.ssm.domain.Menu;
import com.oceanleo.project.ssm.dto.MenuDto;
import com.oceanleo.project.ssm.service.MenuService;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;

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
