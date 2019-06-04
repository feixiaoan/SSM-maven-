package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * 会员接口
 * @author 小飞
 * @date 2019/06/01
 */
public interface IMemberDao {
    /**
     * 根据id查询会员信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{memberId}")
    Member findById(String id) throws Exception;
}
