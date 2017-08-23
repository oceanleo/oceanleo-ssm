package com.ocean.project.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 接口中心
 *
 * @author haiyang.li 2017/7/25.
 */
@Controller
@RequestMapping("/services")
public class ServicesController {

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return null;
    }
}
