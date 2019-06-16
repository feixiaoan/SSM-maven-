package com.xiaofei.ssm.controller;

import com.xiaofei.ssm.domain.SysLog;
import com.xiaofei.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * <Description> <br>
 * 处理日志
 * @author 小飞<br>
 * @version 1.0<br>
 * @createDate 2019/06/10<br>
 * @see com.xiaofei.ssm.controller <br>
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;
    /**
     * 操作开始时间
     */
    private Date visitTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;

    /**
     * 前置通知
     * 主要获取开始时间，执行的哪一类，执行的哪一个方法
     * @param joinPoint
     * @throws NoSuchMethodException
     */
    @Before("execution(* com.xiaofei.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        //当前时间就是开始访问时间
        visitTime = new Date();
        //具体要访问的类
        clazz = joinPoint.getTarget().getClass();
        //获取访问方法的名称
        String methodName = joinPoint.getSignature().getName();
        //获取访问方法的参数
        Object[] args = joinPoint.getArgs();

        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            //只能获取无参数的方法
            method = clazz.getMethod(methodName);
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();

            }
            clazz.getMethod(methodName,classArgs);
        }
    }

    @After("execution(* com.xiaofei.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        long time = System.currentTimeMillis() - visitTime.getTime();
        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class && clazz != SysLogController.class) {
            //获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(**)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
                    //从上下文中获了当前登录的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志封装对象到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUserName(username);
                    sysLog.setVisitTime(visitTime);
                    //调用service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}
