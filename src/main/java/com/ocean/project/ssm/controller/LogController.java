package com.ocean.project.ssm.controller;

import com.ocean.project.ssm.service.LogService;
import com.ocean.project.ssm.support.mvc.controller.BaseController;
import com.ocean.project.ssm.support.orm.query.PageQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author haiyang.li on 2017/11/3
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    @Resource
    private LogService logService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAll(PageQuery query) {
        return logService.findAll(query);
    }
}
