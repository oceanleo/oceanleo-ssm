package com.lhy.ssm.support;

/**
 * 业务异常
 *
 * @author haiyang.li 2017/7/18.
 */
public class BizException extends IllegalStateException {

    public BizException() {}

    public BizException(String s) {super(s);}

    public BizException(String message, Throwable cause) {super(message, cause);}

    public BizException(Throwable cause) {super(cause);}
}
