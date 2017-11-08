package com.oceanleo.project.ssm.support.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author haiyang.li
 */
public class EmailNotifier implements ApplicationListener {

    private String notificationAddress;


    public String getNotificationAddress() {
        return notificationAddress;
    }

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("发送人：" + notificationAddress+"...");
            System.out.println("我已收到通知：" + emailEvent.getEmail() + "要发邮件了。。");
        }
    }
}
