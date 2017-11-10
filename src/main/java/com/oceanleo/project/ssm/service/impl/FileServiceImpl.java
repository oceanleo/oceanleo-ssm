package com.oceanleo.project.ssm.service.impl;

import com.oceanleo.project.ssm.dao.FileDao;
import com.oceanleo.project.ssm.domain.File;
import com.oceanleo.project.ssm.service.FileService;

import javax.annotation.Resource;

/**
 * @author haiyang.li
 */
public class FileServiceImpl implements FileService {

    @Resource
    private FileDao fileDao;

    @Override
    public String createFile(File file) {
        fileDao.insert(file);
        return file.getId();
    }

    @Override
    public File findById(String fileId) {
        return fileDao.selectById(fileId);
    }
}
