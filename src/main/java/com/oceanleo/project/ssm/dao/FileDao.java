package com.oceanleo.project.ssm.dao;

import com.oceanleo.project.ssm.domain.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haiyang.li
 */
public interface FileDao {

    void insert(File file);

    void insertList(@Param("fileList") List<File> fileList);

    File selectById(@Param("id") String id);
}
