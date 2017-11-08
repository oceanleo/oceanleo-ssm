package com.oceanleo.project.ssm.support.core;

import com.oceanleo.project.ssm.domain.Domain;
import com.oceanleo.project.ssm.support.core.access.CurrentUserAccess;
import com.oceanleo.project.ssm.support.security.po.CurrentUser;
import com.oceanleo.project.ssm.support.utils.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author haiyang.li
 */
@Aspect
@Order(2)
@Component
public class DomainSupport {

    @Resource
    private CurrentUserAccess currentUserAccess;

    private static final String DEFAULT_VERSION = "1";

    @Before("execution(public * com.oceanleo..service.*Service.create*(..)) && args(domain,..)")
    public void createDomain(Domain domain) {
        CurrentUser currentUser = getCurrentUser();
        String userId = StringUtils.EMPTY;
        if (currentUser != null) {
            userId = getCurrentUser().getId();
        }
        if (!StringUtils.hasText(domain.getId())) {
            domain.setId(UUID.randomUUID().toString());
        }
        if (domain.getCreateDate() == null) {
            domain.setCreateDate(new Date());
        }
        if (domain.getUpdateDate() == null) {
            domain.setUpdateDate(new Date());
        }
        if (!StringUtils.hasText(domain.getCreateId())) {
            domain.setCreateId(userId);
        }
        if (!StringUtils.hasText(domain.getUpdateId())) {
            domain.setUpdateId(userId);
        }
        if (domain.getDeleted() == null) {
            domain.setDeleted(false);
        }
        if (!StringUtils.hasText(domain.getVersion())) {
            domain.setVersion(DEFAULT_VERSION);
        }
    }

    @Before("execution(public * com.oceanleo..service.*Service.update*(..)) && args(domain,..)")
    public void updateDomain(Domain domain) {
        CurrentUser currentUser = getCurrentUser();
        String userId = StringUtils.EMPTY;
        if (currentUser != null) {
            userId = getCurrentUser().getId();
        }
        domain.setUpdateDate(new Date());
        domain.setUpdateId(userId);
    }

    private CurrentUser getCurrentUser() {
        try {
            return currentUserAccess.getCurrentUser();
        } catch (Exception e) {
            return null;
        }
    }
}
