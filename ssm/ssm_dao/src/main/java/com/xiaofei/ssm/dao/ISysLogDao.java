package com.xiaofei.ssm.dao;

import com.xiaofei.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 日志接口
 * @author 小飞
 * @date 2019/06/10
 */
public interface ISysLogDao {

    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) " +
            "values(uuid(),#{visitTime},#{userName},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志信息
     * @return
     * @throws Exception
     */
    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;
}
