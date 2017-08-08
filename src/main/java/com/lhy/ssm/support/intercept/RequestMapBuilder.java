package com.lhy.ssm.support.intercept;

import com.lhy.ssm.dao.ResourceDao;
import com.lhy.ssm.dto.ResourceDto;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.Resource;
import java.util.*;

/**
 * 查询资源和角色，并构建RequestMap
 *
 * @author haiyang.li on 2017/7/11.
 */
public class RequestMapBuilder extends JdbcDaoSupport{

    @Resource
    private ResourceDao resourceDao;

    //拼接RequestMap
    public Map<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {
        Map<RequestMatcher, Collection<ConfigAttribute>> resourceMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        List<ResourceDto> resourceDtoList = resourceDao.selectDtoAll();
        for (ResourceDto resourceDto : resourceDtoList) {
            Collection<ConfigAttribute> configAttributes;
            ConfigAttribute configAttribute = new SecurityConfig(resourceDto.getRoleCode());
            RequestMatcher requestMatcher = this.getRequestMatcher(resourceDto.getResourceString());
            if(resourceMap.containsKey(requestMatcher)){
                configAttributes = resourceMap.get(requestMatcher);
                configAttributes.add(configAttribute);
            }else{
                configAttributes = new ArrayList<ConfigAttribute>() ;
                configAttributes.add(configAttribute);
                resourceMap.put(requestMatcher, configAttributes);
            }
        }
        return resourceMap;
    }
    //通过一个字符串地址构建一个AntPathRequestMatcher对象
    protected RequestMatcher getRequestMatcher(String url) {
        return new AntPathRequestMatcher(url);
    }
}