package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.IUserDao;
import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.domain.UserInfo;
import com.xiaofei.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description> <br>
 * 用户操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    /**
     *
     * @param id 要查询的id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 保存用户信息
     * @param user
     * @throws Exception
     */
    @Override
    public void save(UserInfo user) throws Exception{
        //对用户信息进行加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    /**
     * 根据用户名密码查询
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo login(String userName, String password) throws Exception {
        UserInfo user = userDao.login(userName, password);
        if (user != null && user.getStatus() == 1) {
            return user;
        }
        return null;
    }

    /**
     * 根据userId查询其他角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findOthersRole(String userId) throws Exception{
        return userDao.findOthersRole(userId);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * 使用UserDetails进行用户登录
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;

        try {
            userInfo = userDao.findByUsername(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将自己的用户对象封装成UserDetails
        //User user = new User(userInfo.getUserName(),"{noop}" + userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserName(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 返回一个List集合，集合中装入的是角色描述
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
