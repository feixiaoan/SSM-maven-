package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Permission;

import java.util.List;

/**
 * 资源权限操作接口
 * @author 小飞
 * @date 2019/06/03
 */
public interface IPermissionService {

    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 添加资源权限
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;
}
