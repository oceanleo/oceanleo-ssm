package com.ocean.project.ssm.support.core.access;

import com.ocean.project.ssm.support.security.po.CurrentUser;

/**
 * 当前用户支持
 *
 * @author haiyang.li on 2017/9/22.
 */
public interface CurrentUserAccess {

    CurrentUser getCurrentUser();
}
