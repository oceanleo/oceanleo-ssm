package com.lhy.ssm.support.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * @author haiyang.li
 */
public class EmailBean implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private List backList;

    public List getBackList() {
        return backList;
    }

    public void setBackList(List backList) {
        this.backList = backList;
    }

    public void sendEmail(EmailEvent email) {
        if (backList.contains(email.getEmail())) {
            applicationContext.publishEvent(email);
        }
    }
}
