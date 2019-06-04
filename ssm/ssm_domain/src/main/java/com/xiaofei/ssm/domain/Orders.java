package com.xiaofei.ssm.domain;

import com.xiaofei.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * <Description> <br>
 * 订单类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.domain <br>
 */
public class Orders {
    /**
     * 订单id
     */
    private String id;
    /**
     * 订单编号 唯一
     */
    private String orderNum;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 下单时间的字符串类型
     */
    private String orderTimeStr;
    /**
     * 出行人数
     */
    private Integer peopleCount;
    /**
     * 订单状态  0 未支付 1 已支付
     */
    private Integer orderStatus;
    /**
     * 订单状态字符串类型
     */
    private String orderStatusStr;
    /**
     * 订单描述
     */
    private String orderDesc;
    /**
     * 支付方式 0 支付宝 1 微信 2 其他
     */
    private Integer payType;
    /**
     * 支付方式的字符串形式
     */
    private String payTypeStr;
    /**
     * 关联的产品信息
     */
    private Product product;
    /**
     * 关联的会员信息
     */
    private Member member;
    /**
     * 关联的旅客信息
     */
    private List<Traveller> travellers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        //将Date类型的时间转换为String类型
        if (orderTime != null) {
            orderTimeStr = DateUtils.DateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态  0 未支付 1 已支付
        if (orderStatus != null) {
            if (orderStatus == 0) {
                orderStatusStr = "未支付";
            }else if (orderStatus == 1) {
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式 0 支付宝 1 微信 2 其他
        if (payType != null) {
            if (payType == 0){
                payTypeStr = "支付宝";
            }else if (payType == 1) {
                payTypeStr = "微信";
            }else if (payType == 2) {
                payTypeStr = "其他";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
