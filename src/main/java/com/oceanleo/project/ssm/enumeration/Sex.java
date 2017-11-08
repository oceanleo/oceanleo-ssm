package com.oceanleo.project.ssm.enumeration;

/**
 * @author haiyang.li on 2017/9/22.
 */
public enum Sex {

    MAN("男"),
    WOMAN("女");

    private String value;

    private Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
