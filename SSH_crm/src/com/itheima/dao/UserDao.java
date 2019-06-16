package com.itheima.dao;

import com.itheima.domain.User;

/**
 * Created by tcj on 2019/6/14.
 */
public interface UserDao {

    //根据登录名称查询user对象
    User getByUserCode(String usercode);
    //保存用户
    void save(User u);
}
