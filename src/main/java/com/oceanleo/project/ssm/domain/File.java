package com.oceanleo.project.ssm.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author haiyang.li
 */
public class File extends Domain implements Serializable {

    private static final long serialVersionUID = 3984397617755967571L;

    private byte[] data;            //文件内容

    private String fileType;        //文件类型

    private String fileName;        //文件名称

    private String suffix;          //文件后缀

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
