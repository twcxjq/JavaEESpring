package com.itheima.service;

import com.itheima.domain.User;

/**
 * Created by tcj on 2019/6/13.
 */
public interface UserService {

    //登录方法
    User getUserByCodePassword(User u);
    //注册用户
    void saveUser(User u);
}
