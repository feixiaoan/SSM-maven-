package com.xiaofei.ssm.service.impl;

import com.xiaofei.ssm.dao.ISysLogDao;
import com.xiaofei.ssm.domain.SysLog;
import com.xiaofei.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 * 日志操作接口
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/10<br>
 * @see com.xiaofei.ssm.service.impl <br>
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    /**
     * 查询日志信息
     * @return
     * @throws Exception
     */
   @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
