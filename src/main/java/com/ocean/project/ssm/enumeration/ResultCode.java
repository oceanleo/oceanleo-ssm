package com.ocean.project.ssm.enumeration;

/**
 * @author haiyang.li 2017/7/18.
 */
public enum ResultCode {

    //正常返回状态码
    SUCCESS("200"),
    //业务异常状态码
    BUSINESS_FAIL("300"),
    //系统异常状态码
    SYSTEM_FAIL("500");

    private String code;

    ResultCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
