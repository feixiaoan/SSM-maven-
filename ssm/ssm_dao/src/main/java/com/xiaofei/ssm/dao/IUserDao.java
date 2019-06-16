package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Role;
import com.xiaofei.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * 用户接口
 * @author 小飞
 * @date 2019/06/02
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,
                    many = @Many(select = "com.xiaofei.ssm.dao.IRoleDao.findRoleById"))

    })
    UserInfo findById(String id) throws Exception;

    /**
     * 保存用户信息
     * @param user
     * @throws Exception
     */
    @Insert("insert into users(id,userName,email,password,phoneNum,status) " +
            "values(uuid(),#{userName},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;

    /**
     * 根据账号密码查询用户
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @Select("select * from users where userName = #{userName} and password = #{password}")
    UserInfo login(@Param("userName") String userName,
                   @Param("password") String password) throws Exception;

    /**
     *根据姓名查询用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    @Select("select * from users where userName = #{userName}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(id = true,property = "userName", column = "userName"),
            @Result(id = true,property = "email", column = "email"),
            @Result(id = true,property = "password", column = "password"),
            @Result(id = true,property = "phoneNum", column = "phoneNum"),
            @Result(id = true,property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.xiaofei.ssm.dao.IRoleDao.findRoleById"))
    })
    UserInfo findByUsername(String userName) throws Exception;

    /**
     * 根据userId查询没有的角色
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOthersRole(String userId);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
