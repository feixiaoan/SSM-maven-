package com.xiaofei.ssm.domain;

import com.xiaofei.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * <Description> <br>
 *  产品的信息
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/05/29<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Product {
    /**
     * 主键
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    /**
     * 出发时间的字符串形式
     */
    private String departureTimeStr;
    /**
     * 产品价格
     */
    private double productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 产品状态
     * 0 关闭 1 开启
     */
    private Integer productStatus;
    /**
     * 产品状态的字符串形式
     * 0 关闭 1 开启
     */
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() throws ParseException {
        //将String类型的日期转换为date类型的
        if (departureTimeStr != null) {
            departureTime = DateUtils.StringTiDate(departureTimeStr,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        //将Date类型的日期转换为String类型的
        if (departureTime != null) {
            departureTimeStr = DateUtils.DateToString(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartrueTimeStr(String departrueTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            //0 关闭 1 开启
            if (productStatus == 0) {
                productStatusStr = "关闭";
            }
            if (productStatus == 1) {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
