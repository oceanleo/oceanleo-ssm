package com.ocean.project.ssm.support.log;

import com.ocean.project.ssm.domain.Log;
import com.ocean.project.ssm.service.LogService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 业务日志记录
 *
 * @author haiyang.li on 2017/9/30.
 */
@Component
public class AppBizLogSupport {

    @Resource
    private LogService logService;

    public void createAppLog(Log log){
        logService.create(log);
    }
}
