package com.ocean.project.ssm.domain;

import com.ocean.framework.utils.DateUtils;
import com.ocean.framework.utils.StringUtils;

import java.io.Serializable;

/**
 * @author haiyang.li
 */
public class User extends Domain implements Serializable {

    private static final long serialVersionUID = 3914969852374588468L;
    //系统内置超级管理员账号
    private static final String ROOT = "root";
    //用户名
    private String username;
    //密码
    private String password;
    //年龄
    private Integer age;
    //性别
    private Boolean sex;
    //姓名
    private String name;
    //状态
    private String status;
    //是否启用
    private boolean isEnabled = true;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
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
                ", isEnabled=" + isEnabled +
                ", DateCreate=" + DateUtils.format(getDateCreate())+
                '}';
    }
}
