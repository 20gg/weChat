package com.team.weChat.aop;

import java.util.Arrays;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.team.weChat.demo.dto.User;

@Aspect
@Component
public class AopAspect {
    
     
    //定义切点
	 @Pointcut("execution(* com.team..*.service..*.*(..))")
    private void serviceLogPoint(){}
    
    
    /**
     * 定义通知类型
     * 写日志
     * @param jp
     * @return
     * @throws Throwable      
     */
    @Around("serviceLogPoint()")
    public Object aroundManagerLogPoint(ProceedingJoinPoint jp) throws Throwable {
    	System.out.println("执行前");
    	
    	Class<?>  c  = jp.getTarget().getClass();
    	
    	System.out.println("接口名称"+c.getName());
    	
    	System.out.println("接口入参参数"+ Arrays.toString(jp.getArgs()));
    	User u =  (User)jp.proceed();
    	System.out.println(u.getName()+" 你的登陆时间是：" + DateFormatUtils.format(u.getLastUpdateDate(), "yyyy-MM-dd HH:mm:ss"));
    	return null;
    }
}

