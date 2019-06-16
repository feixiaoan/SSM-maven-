package com.xiaofei.ssm.service;

import com.xiaofei.ssm.domain.SysLog;

import java.util.List;

/**
 * 日志操作接口
 * @author 小飞
 * @date 2019/06/10
 */
public interface ISysLogService {
    /**
     * 添加日志信息
     * @param sysLog
     * @throws Exception
     */
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志记录
     * @return
     * @throws Exception
     */
    List<SysLog> findAll() throws Exception;
}
