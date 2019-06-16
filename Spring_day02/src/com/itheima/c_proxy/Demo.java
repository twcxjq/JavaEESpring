package com.itheima.c_proxy;

import com.itheima.c_service.UserService;
import com.itheima.c_service.UserServiceImpl;
import org.junit.Test;

/**
 * Created by tcj on 2019/6/10.
 */
public class Demo {

    @Test
    public void fun1() {
        UserService us = new UserServiceImpl();
        UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
        UserService usProxy = factory.getUserServiceProxy();
        usProxy.save();

        //代理对象与被代理对象实现了相同的接口
        //代理对象与被代理对象之间没有继承关系
        System.out.println(usProxy instanceof UserServiceImpl);  //false
    }

    @Test
    public void fun2() {
        UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
        UserService usProxy = factory.getUserServiceProxy();
        usProxy.save();

        //判断代理对象是否属于被代理对象类型的
        //代理对象继承了被代理对象=>true
        System.out.println(usProxy instanceof UserServiceImpl);  //true
    }
}
