package com.xiaofei.ssm.controller;

import com.xiaofei.ssm.domain.Product;
import com.xiaofei.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * <Description> <br>
 * 产品控制器
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/05/29<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> all = productService.findAll();
        mv.addObject("productList",all);
        mv.setViewName("product-list1");
        return mv;
    }

    /**
     * 添加产品信息
     * @param product
     * @return 重新查询一遍产品信息
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String  save(Product product) throws Exception {
        productService.sava(product);
        //重新查询产品信息
        return "redirect:findAll.do";
    }
}
