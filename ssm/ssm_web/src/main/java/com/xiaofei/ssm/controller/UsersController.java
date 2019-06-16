package com.xiaofei.ssm.controller;

import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.domain.UserInfo;
import com.xiaofei.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <Description> <br>
 * 用户操作
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUserService userService;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId",required = true) String userId,
                                @RequestParam(value = "ids",required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    /**
     * 查询用户以及给用户添加角色
     * @param userId
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户的id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> list = userService.findOthersRole(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",list);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 登录验证
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/login.do")
    public String login(@RequestParam(name = "userName",required = true) String userName,
                        @RequestParam(name = "password", required = true) String password) throws Exception {
        UserInfo user = userService.login(userName, password);
        if (user != null) {
            return "main";
        }
        return "/login.jsp";
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }
}
