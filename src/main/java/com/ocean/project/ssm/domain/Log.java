package com.ocean.project.ssm.domain;

/**
 * 日志
 *
 * @author haiyang.li on 2017/8/30.
 */
public class Log extends Domain {

    //模块
    private String model;
    //访问方法名
    private String methodName;
    //访问参数
    private String arguments;
    //是否访问成功
    private String isSuccess;

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

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
