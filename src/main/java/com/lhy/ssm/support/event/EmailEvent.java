package com.lhy.ssm.support.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @author haiyang.li
 */
public class EmailEvent extends ApplicationEvent {

    private String address;

    private String text;

    private String email;

    private Logger logger = LoggerFactory.getLogger(EmailEvent.class);

    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(String email, String text, String address) {
        super(email);
        this.address = address;
        this.email = email;
        this.text = text;
    }

    public void printInfo() {
        logger.info("Send this Email, address:" + address + " text:" + text);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
