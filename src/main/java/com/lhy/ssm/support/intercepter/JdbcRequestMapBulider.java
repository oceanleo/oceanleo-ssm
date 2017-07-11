package com.lhy.ssm.support.intercepter;

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
 * @author haiyang.li on 2017/7/11.
 *
 * 查询资源和角色，并构建RequestMap
 */
public class JdbcRequestMapBulider extends JdbcDaoSupport{

    //查询资源和权限关系的sql语句
//    private String resourceQuery = "";

    @Resource
    private ResourceDao resourceDao;


//    public String getResourceQuery() {
//        return resourceQuery;
//    }

//    public void setResourceQuery(String resourceQuery) {
//        this.resourceQuery = resourceQuery;
//    }
//
//    //查询资源
//    public List<Resource> findResources() {
//        ResourceMapping resourceMapping = new ResourceMapping(getDataSource(), resourceQuery);
//        return resourceMapping.execute();
//    }

    //拼接RequestMap
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        List<ResourceDto> resourceDtoList = resourceDao.selectDtoAll();
        //配置文件中不应该写sql语句
//        List<Resource> resourceList = this.findResources();
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

//    /**
//     * 资源内部类
//     */
//    private class Resource {
//        //资源访问的地址
//        private String url;
//        //所需要的权限
//        private String role;
//
//        public Resource(String url, String role) {
//            this.url = url;
//            this.role = role;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public String getRole() {
//            return role;
//        }
//    }
//
//    private class ResourceMapping extends MappingSqlQuery {
//
//        protected ResourceMapping(DataSource dataSource, String resourceQuery) {
//            super(dataSource, resourceQuery);
//            compile();
//        }
//        //对结果集进行封装处理
//        protected Object mapRow(ResultSet rs, int rownum)
//                throws SQLException {
//            String url = rs.getString(1);
//            String role = rs.getString(2);
//            Resource resource = new Resource(url, role);
//            return resource;
//        }
//    }


}