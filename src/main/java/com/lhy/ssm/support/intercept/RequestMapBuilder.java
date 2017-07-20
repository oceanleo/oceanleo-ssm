package com.lhy.ssm.support.intercept;

import com.lhy.ssm.dao.ResourceDao;
import com.lhy.ssm.dto.ResourceDto;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 查询资源和角色，并构建RequestMap
 *
 * @author haiyang.li on 2017/7/11.
 */
public class RequestMapBuilder extends JdbcDaoSupport{

    @Resource
    private ResourceDao resourceDao;

    //拼接RequestMap
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        List<ResourceDto> resourceDtoList = resourceDao.selectDtoAll();
        for (ResourceDto resourceDto : resourceDtoList) {
            //封装url
            RequestMatcher requestMatcher = this.getRequestMatcher(resourceDto.getResourceString());
            List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
            //封装角色编码
            list.add(new SecurityConfig(resourceDto.getRoleCode()));
            requestMap.put(requestMatcher, list);
        }
        return requestMap;
    }
    //通过一个字符串地址构建一个AntPathRequestMatcher对象
    protected RequestMatcher getRequestMatcher(String url) {
        return new AntPathRequestMatcher(url);
    }
}