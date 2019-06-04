package com.xiaofei.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.xiaofei.ssm.dao.IOrdersDao;
import com.xiaofei.ssm.domain.Orders;
import com.xiaofei.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 * 订单操作
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 查询所有订单信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(int page,int pageSize) throws Exception {
        //利用通用分页拦截器的startPage方法进行分页
        //此方法必须放在查询方法之前，必须相邻
        PageHelper.startPage(page,pageSize);
        List<Orders> ordersDaoAll = ordersDao.findAll();
        return ordersDaoAll;
    }

    /**
     * 根据id查询订单
     * @param ordersId 要查询的ordersId
     * @return
     * @throws Exception
     */
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
