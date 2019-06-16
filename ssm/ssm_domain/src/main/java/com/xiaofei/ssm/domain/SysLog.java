package com.xiaofei.ssm.domain;

import com.xiaofei.ssm.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * <Description> <br>
 * 日志类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/10<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class SysLog {

    /**
     * 主键 uuid()
     */
    private String id;
    /**
     * 访问时间
     */
    private Date visitTime;
    /**
     * 访问时间的字符串形式
     */
    private String visitTimeStr;
    /**
     * 操作者的用户名
     */
    private String userName;
    /**
     * 访问ip
     */
    private String ip;
    /**
     * 访问资源url
     */
    private String url;
    /**
     * 执行时长
     */
    private Long executionTime;
    /**
     * 访问方法
     */
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() throws ParseException {
        if (visitTimeStr != null) {
            visitTime = DateUtils.StringTiDate(visitTimeStr,"yyyy-MM-dd HH:mm:ss");
        }
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        if(visitTime != null) {
            visitTimeStr = DateUtils.DateToString(visitTime,"yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
