package com.lhy.ssm.support.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author haiyang.li
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("AppContextListener---context---Initialized---");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("AppContextListener---context---Destroyed---");
    }
}
