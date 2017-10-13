package com.ocean.project.ssm.support.mvc.controller;

import com.ocean.project.ssm.support.core.access.CurrentUserAccess;
import com.ocean.project.ssm.support.security.po.CurrentUser;

import javax.annotation.Resource;

/**
 * 基础控制层
 *
 * @author haiyang.li on 2017/9/22.
 */
public class BaseController {

    @Resource
    private CurrentUserAccess currentUserAccess;

    protected String getUserId() {
        return getUserInfo().getId();
    }

    final protected <T extends CurrentUser> T getUserInfo() {
        return (T) currentUserAccess.getCurrentUser();
    }
}
