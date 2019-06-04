package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.IPermissionDao;
import com.xiaofei.ssm.domain.Permission;
import com.xiaofei.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 * 资源权限操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/03<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    /**
     * 查询所有资源权限
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /**
     * 添加资源权限
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
