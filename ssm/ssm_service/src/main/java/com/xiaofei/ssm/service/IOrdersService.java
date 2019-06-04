package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Orders;

import java.util.List;

/**
 * <Description> <br>
 * 订单操作
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.service <br>
 */
public interface IOrdersService {
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int pageSize) throws Exception;

    /**
     * 根据id查询订单信息
     * @param ordersId 要查询的ordersId
     * @return
     * @throws Exception
     */
    Orders findById(String ordersId) throws Exception;
}
