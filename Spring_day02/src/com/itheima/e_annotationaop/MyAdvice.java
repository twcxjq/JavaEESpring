package com.itheima.e_annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by tcj on 2019/6/11.
 */

//通知类
@Aspect
//表示该类是一个通知类
public class MyAdvice {

    @Pointcut("execution(* com.itheima.c_service.*ServiceImpl.*(..))")
    public void pc() {}

    //前置通知
    //指定该方法是前置通知,并指定切入点
    @Before("MyAdvice.pc()")
    public void before() {
        System.out.println("这是前置通知!");
    }

    //后置通知
    @AfterReturning("execution(* com.itheima.c_service.*ServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("这是后置通知(如果出现异常不会调用)!");
    }

    //环绕通知
    @Around("execution(* com.itheima.c_service.*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分!");
        return proceed;
    }

    //异常拦截通知
    @AfterThrowing("execution(* com.itheima.c_service.*ServiceImpl.*(..))")
    public void afterException() {
        System.out.println("这是异常拦截通知,出现异常了!");
    }

    //后置通知
    @After("execution(* com.itheima.c_service.*ServiceImpl.*(..))")
    public void after() {
        System.out.println("这是后置通知(无论是否出现异常都会调用)!");
    }
}
