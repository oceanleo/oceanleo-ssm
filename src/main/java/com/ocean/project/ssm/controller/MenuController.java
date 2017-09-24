package com.ocean.project.ssm.controller;

import com.ocean.project.ssm.service.MenuService;
import com.ocean.project.ssm.support.mvc.controller.BaseController;
import com.ocean.project.ssm.support.orm.query.PageQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author haiyang.li on 2017/9/24.
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getRoleAll(PageQuery query){
        return menuService.getPageList(query);
    }
}
