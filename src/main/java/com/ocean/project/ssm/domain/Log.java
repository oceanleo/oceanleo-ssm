package com.ocean.project.ssm.domain;

import java.io.Serializable;

/**
 * 日志
 *
 * @author haiyang.li on 2017/8/30.
 */
public class Log extends Domain implements Serializable {

    private static final long serialVersionUID = -1228373527877362434L;
    //模块
    private String model;
    //访问方法名
    private String methodName;
    //访问参数
    private String arguments;
    //是否访问成功
    private Boolean success;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Log{" +
                "model='" + model + '\'' +
                ", methodName='" + methodName + '\'' +
                ", arguments='" + arguments + '\'' +
                ", success=" + success +
                '}';
    }
}
