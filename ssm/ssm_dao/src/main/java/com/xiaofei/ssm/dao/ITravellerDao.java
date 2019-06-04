package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 旅客接口
 * @author 小飞
 * @date 2019/06/01
 */
public interface ITravellerDao {
    /**
     * 根据订单id查询旅客信息
     * @param orderId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findByOrdersId(String orderId) throws Exception;
}
