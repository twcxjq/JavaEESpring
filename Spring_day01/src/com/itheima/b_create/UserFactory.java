package com.itheima.b_create;

import com.itheima.bean.User;

/**
 * Created by tcj on 2019/6/7.
 */
public class UserFactory {

    public static User createUser() {
        System.out.println("静态工厂创建User对象");
        return new User();
    }

    public User createUser2() {
        System.out.println("实例工厂创建User对象");
        return new User();
    }
}
