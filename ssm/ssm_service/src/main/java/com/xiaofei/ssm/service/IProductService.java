package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Product;

import java.util.List;

/**
 * 产品操作
 * @author 小飞
 * @date 2019/5/29
 */
public interface IProductService {
    /**
     *查询所有产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 添加产品信息
     * @param product
     * @throws Exception
     */
    void sava(Product product) throws Exception;
}
