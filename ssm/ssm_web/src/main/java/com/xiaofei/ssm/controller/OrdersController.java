package com.xiaofei.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xiaofei.ssm.domain.Orders;
import com.xiaofei.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <Description> <br>
 *  订单控制器类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/01<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 根据ordersId查询订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
    /**
     * 分页查询所有产品信息
     * @param page 传入的页码
     * @param pageSize 每页的条数
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true,defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true,defaultValue = "4") int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,pageSize);
        //利用PageHelper分页工具进行分页
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
}
