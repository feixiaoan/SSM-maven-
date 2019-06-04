package com.xiaofei.ssm.controller;

import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <Description> <br>
 * 角色操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/03<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private IRoleService roleService;

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
