package com.oceanleo.project.ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author haiyang.li on 2017/9/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class DataSourceTest {

    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private OracleService oracleService;

    @Test
    public void testGetBean() throws Exception {
//        DataSource dataSource = (DataSource) applicationContext.getBean("ssmDataSource");
//        if (dataSource != null) {
//            Connection connection = dataSource.getConnection();
//            String sql = "select 1 from dual";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                System.out.println(resultSet.getInt(1));
//            }
//            connection.close();
//        }
    }

    @Test
    public void testOracleConnect() throws Exception {
//        System.out.println(oracleService.testConnect());
    }
}
