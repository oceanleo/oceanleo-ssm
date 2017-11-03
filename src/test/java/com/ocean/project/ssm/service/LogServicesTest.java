package com.ocean.project.ssm.service;

import com.ocean.project.ssm.domain.Log;
import com.ocean.project.ssm.support.orm.query.PageQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haiyang.li on 2017/11/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring/*.xml"})
public class LogServicesTest {

    @Resource
    private LogService logService;

    @Test
    public void testFindAll() {
        List<Log> logList = logService.findAll(new PageQuery());
        for (Log log : logList) {
            System.out.println(log);
        }
    }

    @Test
    public void testCreate() {
//        List<Log> logList = new ArrayList<>();
//        for (int i = 200001; i <= 1000000; i++) {
//            Log log = new Log();
//            log.setId("" + i);
//            log.setModel("model-" + i);
//            log.setMethodName("methodName-" + i);
//            log.setArguments("Arguments" + i);
//            log.setSuccess(true);
//            logList.add(log);
//            if(logList.size()>=5000){
//                logService.createList(logList);
//                logList.clear();
//            }
//        }
    }
}
