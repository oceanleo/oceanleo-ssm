package com.lhy.ssm.support.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/*.xml",
        "classpath:test/*.xml"})
public class EmailEventTest{

    @Resource
    private EmailBean emailBean;

    @Test
    public void testSendEmail(){
        EmailEvent emailEvent = new EmailEvent("373045912@qq.com","邮件text","邮件address");
        emailBean.sendEmail(emailEvent);
    }
}
