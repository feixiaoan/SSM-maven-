package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色操作接口
 * @author 小飞
 * @date 2019/06/02
 */
public interface IRoleDao {
    /**
     * 根据id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in ( select roleId from users_role where userId = #{id})")
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
}
