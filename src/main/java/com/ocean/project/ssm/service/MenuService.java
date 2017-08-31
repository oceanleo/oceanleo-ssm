package com.ocean.project.ssm.service;

import com.ocean.project.ssm.dto.MenuDto;
import com.ocean.project.ssm.support.log.Log;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/29.
 */
@Log("菜单业务层")
public interface MenuService {

    @Log("获取所有的菜单")
    List<MenuDto> findAllMenu();
}
