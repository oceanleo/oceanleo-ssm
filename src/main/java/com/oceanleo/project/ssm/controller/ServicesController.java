package com.oceanleo.project.ssm.controller;

import com.oceanleo.project.ssm.service.OracleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 接口中心
 *
 * @author haiyang.li 2017/7/25.
 */
@Controller
@RequestMapping("/services")
public class ServicesController {

    @Resource
    private OracleService oracleService;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return oracleService.testConnect();
    }
}
