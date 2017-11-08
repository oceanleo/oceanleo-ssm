package com.oceanleo.project.ssm.support.core.exception;

/**
 * 业务异常
 *
 * @author haiyang.li on 2017/9/21.
 */
public class BizException extends IllegalArgumentException {
    public BizException() {
    }

    public BizException(String s) {
        super(s);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}