package com.xiaofei.ssm.dao;

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
}
