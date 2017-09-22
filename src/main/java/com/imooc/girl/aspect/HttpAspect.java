package com.imooc.girl.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    //LGG，一定要用slf4j
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    //面向切面的编程
    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log( )")
    public void doBefore(JoinPoint joinPoint){
        //logger.info("111111");

        //url
        ServletRequestAttributes attributes=(ServletRequestAttributes)  RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @AfterReturning(returning="object",pointcut="log()")
    public void doAfter(Object object){
        logger.info("response={}",object.toString());
        //logger.info("22222");

    }

}
