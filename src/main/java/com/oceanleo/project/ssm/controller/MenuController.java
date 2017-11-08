package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.service.MenuService;
import com.oceanleo.project.ssm.support.mvc.controller.BaseController;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 菜单控制层
 *
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
