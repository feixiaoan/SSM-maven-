package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Permission;
import com.xiaofei.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 角色操作接口
 * @author 小飞
 * @date 2019/06/02
 */
public interface IRoleDao {
    /**
     * 根据用户id查询对应的角色
     * @param id 用户的id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in ( select roleId from users_role where userId = #{id})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result( column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions",javaType = java.util.List.class,
                many = @Many(select = "com.xiaofei.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    List<Role> findRoleById(String id) throws Exception;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(id,roleName,roleDesc) values(uuid(),#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId) throws Exception;

    /**
     * 根据roleId查询其他权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId) throws Exception;
}
