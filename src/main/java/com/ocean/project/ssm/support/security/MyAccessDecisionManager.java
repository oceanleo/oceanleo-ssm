package com.ocean.project.ssm.support.security;

import com.ocean.framework.utils.DateUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class MyAccessDecisionManager implements AccessDecisionManager {

    /*
     * 该方法决定该权限是否有权限访问该资源，其实object就是一个资源的地址，authentication是当前用户的
     * 对应权限，如果没登陆就为游客，登陆了就是该用户对应的权限
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null) {
            return;
        }
        //所请求的资源拥有的权限(一个资源对多个权限)
        for (ConfigAttribute configAttribute : configAttributes) {
            String needPermission = configAttribute.getAttribute();
            System.out.println(DateUtils.format(new Date()) + " 访问" + object.toString() + "需要的权限是：" + needPermission);
            //用户所拥有的权限authentication
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority ga : authorities) {
                if (needPermission.equals(ga.getAuthority())) {
                    System.out.println(DateUtils.format(new Date()) + " 访问" + object.toString() + "有权限，放行，用户权限:" + ga.getAuthority());
                    return;
                }
            }
        }
        System.out.println(DateUtils.format(new Date()) + " 访问" + object.toString() + "没有权限，被拦截");
        //没有权限
        throw new AccessDeniedException("没有权限访问！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
