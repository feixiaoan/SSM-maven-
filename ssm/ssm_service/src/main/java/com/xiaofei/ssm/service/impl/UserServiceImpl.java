package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.IUserDao;
import com.xiaofei.ssm.domain.UserInfo;
import com.xiaofei.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 * 用户操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/02<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

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
}
