package com.oceanleo.project.ssm.domain;

import com.oceanleo.project.ssm.support.utils.StringUtils;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class User extends Domain implements Serializable {

    private static final long serialVersionUID = 3914969852374588468L;

    private static final String ROOT = "root";      //系统内置超级管理员账号

    private String username;        //用户名

    private String password;        //密码

    private Integer age;            //年龄

    private Boolean sex;            //性别

    private String name;            //姓名

    private String status;          //状态

    private Boolean enabled;        //是否启用

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public boolean isRoot(){
        return StringUtils.hasText(this.getUsername())&&ROOT.equals(this.getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
