package com.ocean.project.ssm.service;

import com.ocean.project.ssm.dto.MenuDto;

import java.util.List;

/**
 * @author haiyang.li on 2017/8/29.
 */
public interface MenuService {

    List<MenuDto> findAllMenu();
}
