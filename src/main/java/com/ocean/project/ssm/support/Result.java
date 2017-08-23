package com.ocean.project.ssm.support;

import com.ocean.project.ssm.enumeration.ResultCode;

/**
 * 控制层返回的封装对象
 *
 * @author haiyang.li 2017/7/18.
 */
public class Result {

    //状态
    private boolean status = true;
    //状态码
    private ResultCode resultCode = ResultCode.SUCCESS;
    //状态码
    private String statusCode;
    //返回数据
    private Object resultData;
    //异常信息
    private String message;

    public Result(Object resultData) {
        this.resultData = resultData;
    }

    public Result(boolean status,ResultCode resultCode, String message) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getStatusCode() {
        return this.resultCode.getCode();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
