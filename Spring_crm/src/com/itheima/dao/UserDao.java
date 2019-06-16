package com.itheima.dao;

import com.itheima.domain.User;

/**
 * Created by tcj on 2019/6/4.
 */
public interface UserDao {
    //根据登录名返回User对象
    User getByUserCode(String user_code);
}
