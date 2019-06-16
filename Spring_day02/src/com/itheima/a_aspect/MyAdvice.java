package com.itheima.a_aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by tcj on 2019/6/11.
 */

//通知类
public class MyAdvice {

    //前置通知
//		|-目标方法运行之前调用
    //后置通知(如果出现异常不会调用)
//		|-在目标方法运行之后调用
    //环绕通知
//		|-在目标方法运行之前和运行之后都调用
    //异常拦截通知
//		|-如果出现异常,就会调用
    //后置通知(无论是否出现异常都会调用)
//		|-在目标方法运行之后调用

//在Spring的通知类中是使用方法来定义通知类的
//----------------------------------------------------------------
    //前置通知
    public void before() {
        System.out.println("这是前置通知!");
    }

    //后置通知
    public void afterReturning() {
        System.out.println("这是后置通知(如果出现异常不会调用)!");
    }

    //环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分!");
        return proceed;
    }

    //异常拦截通知
    public void afterException() {
        System.out.println("这是异常拦截通知,出现异常了!");
    }

    //后置通知
    public void after() {
        System.out.println("这是后置通知(无论是否出现异常都会调用)!");
    }
}
