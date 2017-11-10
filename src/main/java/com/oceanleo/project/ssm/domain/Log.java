package com.oceanleo.project.ssm.domain;

import java.io.Serializable;

/**
 * 日志
 *
 * @author haiyang.li on 2017/8/30.
 */
public class Log extends Domain implements Serializable {

    private static final long serialVersionUID = -1228373527877362434L;

    private String model;           //模块

    private String methodName;      //方法名

    private String arguments;       //参数

    private Boolean success;        //是否访问成功

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
