package com.itheima.service;

import com.itheima.domain.User;

/**
 * Created by tcj on 2019/6/4.
 */
public interface UserService {
    //执行登录业务
    User login(User user);
}
