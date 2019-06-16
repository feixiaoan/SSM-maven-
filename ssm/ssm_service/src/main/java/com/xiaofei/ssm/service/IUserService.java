package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户接口
 * @author 小飞
 * @date 2019/06/02
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 根据id查询用户
     * @param id 要查询的id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 保存用户信息
     * @param user
     * @throws Exception
     */
    void save(UserInfo user) throws Exception;

    /**
     * 根据用户名密码查询
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    UserInfo login(String userName, String password) throws Exception;

    /**
     * 根据id查询其他角色
     * @param userId
     * @return
     */
    List<Role> findOthersRole(String userId) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
