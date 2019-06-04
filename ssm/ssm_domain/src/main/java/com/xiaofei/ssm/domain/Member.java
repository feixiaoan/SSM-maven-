package com.xiaofei.ssm.domain;

/**
 * <Description> <br>
 *  会员类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Member {
    /**
     *会员id
     */
    private String id;
    /**
     *会员姓名
     */
    private String name;
    /**
     *会员昵称
     */
    private String nickName;
    /**
     *电话号码
     */
    private String phoneNum;
    /**
     *邮箱
     */
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
