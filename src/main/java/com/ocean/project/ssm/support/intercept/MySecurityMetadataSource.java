package com.ocean.project.ssm.support.intercept;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = null;
    // 资源权限集合
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;
    //查找数据库权限和资源关系
    private RequestMapBuilder requestMapBuilder;

    /*
     * 根据访问资源的地址查找所需要的权限
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                attrs = entry.getValue();
                break;
            }
        }
        return attrs;
    }

    /*
     * 获取所有的权限
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        System.out.println("总共有这些权限：" + allAttributes.toString());
        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    //绑定requestMap
    protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
        return requestMapBuilder.buildRequestMap();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.requestMap = this.bindRequestMap();
    }

    public void refreshResourceMap() {
        this.requestMap = this.bindRequestMap();
    }

    public RequestMapBuilder getRequestMapBuilder() {
        return requestMapBuilder;
    }

    public void setRequestMapBuilder(RequestMapBuilder requestMapBuilder) {
        this.requestMapBuilder = requestMapBuilder;
    }
}
