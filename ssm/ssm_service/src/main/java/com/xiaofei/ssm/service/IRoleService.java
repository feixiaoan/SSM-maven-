package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Role;

import java.util.List;

/**
 * 角色操作接口
 * @author 小飞
 * @date 2019/06/03
 */
public interface IRoleService {
    /**
     * 查询所有的角色
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;
}
