package com.oceanleo.project.ssm.support.core.access;

import com.oceanleo.project.ssm.support.core.exception.BizException;
import com.oceanleo.project.ssm.support.security.po.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前用户相关信息
 *
 * @author haiyang.li on 2017/9/22.
 */
public class CurrentUserAccessImpl implements CurrentUserAccess {

    @Override
    public CurrentUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal == null){
            throw new BizException("获取当前用户失败");
        }
        return (CurrentUser)principal;
    }
}
