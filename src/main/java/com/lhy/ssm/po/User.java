package com.lhy.ssm.po;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class User extends Domain implements Serializable {

    private static final long serialVersionUID = 3914969852374588468L;
    //用户名
    private String username;
    //密码
    private String password;
    //年龄
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
