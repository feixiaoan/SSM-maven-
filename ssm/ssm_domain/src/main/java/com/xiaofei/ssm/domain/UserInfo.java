package com.xiaofei.ssm.domain;

import java.util.List;

/**
 * <Description> <br>
 * 与数据库中的Users表对应
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class UserInfo {
    /**
     * 主键 uuid
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户邮箱 唯一
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 用户状态 0 未开启 1 开启
     */
    private Integer status;
    /**
     * 用户状态的字符串
     */
    private String statusStr;
    /**
     * 用户的多个角色
     */
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        //用户状态 0 未开启 1 开启
        if (status != null) {
            if (status == 0) {
                statusStr = "未开启";
            }else if (status == 1) {
                statusStr = "开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
