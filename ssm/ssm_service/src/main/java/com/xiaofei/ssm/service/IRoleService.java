package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.Permission;
import com.xiaofei.ssm.domain.Role;

import java.util.List;

/**
 * 角色操作接口
 * @author 小飞
 * @date 2019/06/03
 */
public interface IRoleService {
    /**
     * 根据id查询角色
     * @param roleId
     * @return
     * @throws Exception
     */
     Role findById(String roleId) throws Exception;

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

    /**
     * 根据roleId查询其他权限
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
