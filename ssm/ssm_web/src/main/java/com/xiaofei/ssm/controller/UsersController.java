package com.xiaofei.ssm.controller;

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
     * 保存用户信息
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
