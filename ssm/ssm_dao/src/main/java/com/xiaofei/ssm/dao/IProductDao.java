package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品的dao层方法
 * @author 小飞
 * @date 2019/06/01
 */
public interface IProductDao {
    /**
     * 根据id查询产品信息
     * @param id 要查询的id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{productId}")
    Product findById(String id) throws Exception;

    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 添加产品信息
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(uuid(),#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}
