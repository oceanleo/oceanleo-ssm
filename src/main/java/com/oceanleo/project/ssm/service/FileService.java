package com.oceanleo.project.ssm.service;

import com.oceanleo.project.ssm.domain.File;
import com.oceanleo.project.ssm.support.log.AppLog;

/**
 * @author haiyang.li
 */
@AppLog("文件上传业务层")
public interface FileService {

    @AppLog("上传文件")
    String createFile(File file);

    File findById(String fileId);
}
