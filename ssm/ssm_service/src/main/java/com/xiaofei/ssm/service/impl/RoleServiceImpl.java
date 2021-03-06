package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.IRoleDao;
import com.xiaofei.ssm.domain.Permission;
import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 * 角色操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/03<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return  roleDao.findAll();
    }

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 根据roleId查询其他权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
