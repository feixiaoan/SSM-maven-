package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 资源权限管理
 * @author 小飞
 * @date 2019/06/03
 */
public interface IPermissionDao {
    /**
     * 查询所有权限信息
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    /**
     * 添加资源权限
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(id,permissionName,url) values(uuid(),#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    /**
     * 根据RoleId查询所有资源权限
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in(" +
            "select permissionId from role_permission where RoleId = #{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;
}
