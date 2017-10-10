package com.ocean.project.ssm.support.mvc.po;

/**
 * 统一返回前端数据封装
 *
 * @author haiyang.li on 2017/9/21.
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getStatusCode() {
        return this.resultCode.getCode();
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
