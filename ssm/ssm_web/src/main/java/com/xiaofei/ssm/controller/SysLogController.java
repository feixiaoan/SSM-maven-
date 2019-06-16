package com.xiaofei.ssm.controller;

import com.xiaofei.ssm.domain.SysLog;
import com.xiaofei.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <Description> <br>
 * 日志
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/10<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    /**
     * 查询所有日志信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        for(SysLog sysLog : sysLogList) {
            System.out.println(sysLog);
        }
        mv.addObject("sysLogs",sysLogList);
        mv.setViewName("syslog-list");
        return  mv;
    }
}
