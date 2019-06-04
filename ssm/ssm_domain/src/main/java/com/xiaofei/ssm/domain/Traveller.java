package com.xiaofei.ssm.domain;

/**
 * <Description> <br>
 * 旅客类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Traveller {
    /**
     * 旅客id uuid()
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 证件类型 0 身份证 1 护照 2 军官证
     */
    private Integer credentialsType;
    /**
     * 证件类型的字符串
     */
    private String credentialsTypeStr;
    /**
     * 证件号码
     */
    private String credentialsNum;
    /**
     * 旅客类型（人群） 0 成人 1儿童
     */
    private Integer travellerType;
    /**
     * 旅客类型字符串形式
     */
    private String travellerTypeStr;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //证件类型 0 身份证 1 护照 2 军官证
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            }else if (credentialsType == 1) {
                credentialsTypeStr = "护照";
            }else if (credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        //旅客类型（人群） 0 成人 1儿童
        if (travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr = "成人";
            }else if (travellerType == 1) {
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}

