package com.lhy.ssm.support;

import com.lhy.ssm.po.Domain;
import com.lhy.ssm.support.utils.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author haiyang.li
 */
@Aspect
@Order(2)
@Component
public class DomainSupport {

    private static final String version = "1";

    @Before("execution(public * com.lhy.ssm.service.*Service.create*(..)) && args(domain,..)")
    public void createDomain(Domain domain){
        if (!StringUtils.hasText(domain.getId())){
            domain.setId(UUID.randomUUID().toString());
        }
        if(domain.getDateCreate()==null){
            domain.setDateCreate(new Date());
        }
        if(domain.getDateUpdate()==null){
            domain.setDateUpdate(new Date());
        }
        if(domain.getDeleted()==null){
            domain.setDeleted(false);
        }
        if(!StringUtils.hasText(domain.getVersion())){
            domain.setVersion(version);
        }
    }
}
