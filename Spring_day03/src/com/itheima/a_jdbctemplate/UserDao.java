package com.itheima.a_jdbctemplate;

import com.itheima.bean.User;

import java.util.List;

/**
 * Created by tcj on 2019/6/11.
 */
public interface UserDao {

    //增
    void save(User u);
    //删
    void dalete(Integer id);
    //改
    void update(User u);
    //查
    User getById(Integer id);
    //查
    int getTotalCount();
    //查
    List<User> getAll();
}
