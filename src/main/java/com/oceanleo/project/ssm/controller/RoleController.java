package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.domain.Role;
import com.oceanleo.project.ssm.service.RoleService;
import com.oceanleo.project.ssm.support.mvc.controller.BaseController;
import com.oceanleo.project.ssm.support.orm.query.PageQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 角色控制层
 *
 * @author haiyang.li on 2017/9/24.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getRoleAll(PageQuery query){
        return roleService.getPageList(query);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Object getCreate(Role role){
        roleService.create(role);
        return "添加成功";
    }
}
