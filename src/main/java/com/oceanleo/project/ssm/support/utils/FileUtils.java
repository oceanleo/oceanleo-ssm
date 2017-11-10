package com.oceanleo.project.ssm.support.utils;

import com.oceanleo.project.ssm.domain.File;
import com.oceanleo.project.ssm.support.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author haiyang.li
 */
public abstract class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static File toFile(MultipartFile uploadFile) {
        if (uploadFile != null && !uploadFile.isEmpty()) {
            try {
                File file = new File();
                file.setData(uploadFile.getBytes());
                String fileName = uploadFile.getOriginalFilename();
                file.setFileName(fileName);
                file.setFileType(uploadFile.getContentType());
                file.setSuffix(fileName.substring(fileName.lastIndexOf(StringUtils.DOT)));
                return file;
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new BizException("文件对象转换错误");
            }
        } else {
            throw new BizException("文件为空");
        }
    }
}
