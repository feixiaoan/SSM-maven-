package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.IProductDao;
import com.xiaofei.ssm.domain.Product;
import com.xiaofei.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *  产品操作实现类
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/05/29<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    /**
     * 添加产品信息
     * @param product
     * @throws Exception
     */
    @Override
    public void sava(Product product) throws Exception {
        productDao.save(product);
    }
}
