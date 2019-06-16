package com.itheima.c_proxy;

import com.itheima.c_service.UserService;
import com.itheima.c_service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by tcj on 2019/6/10.
 */

//观光代码=>动态代理
public class UserServiceProxyFactory implements InvocationHandler {

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    private UserService us;

    public UserService getUserServiceProxy() {
        //生成代理对象
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), this);
        //返回
        return usProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务");
        Object invoke = method.invoke(us, args);
        System.out.println("提交事务");
        return invoke;
    }
}
