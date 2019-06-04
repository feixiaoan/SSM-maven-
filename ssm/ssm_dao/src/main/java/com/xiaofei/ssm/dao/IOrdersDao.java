package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Member;
import com.xiaofei.ssm.domain.Orders;
import com.xiaofei.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单操作
 * @author 小飞
 * @date 2019/06/01
 */
public interface IOrdersDao {
    /**
     * 根据ordersId查询订单信息
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id= #{ordersId}")
    @Results({
            @Result(id=true,column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "productId", property = "product",javaType = Product.class,
                    one=@One(select="com.xiaofei.ssm.dao.IProductDao.findById")),
            @Result(column = "memberId", property = "member",javaType = Member.class,
                    one=@One(select = "com.xiaofei.ssm.dao.IMemberDao.findById")),
            @Result(column = "id", property = "travellers",javaType = java.util.List.class,
                    many = @Many(select = "com.xiaofei.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "productId", property = "product",javaType = Product.class,one=@One(select="com.xiaofei.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;
}
