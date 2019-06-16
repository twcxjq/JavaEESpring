package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tcj on 2019/6/13.
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Override
    public User getUserByCodePassword(User u) {
        //1,根据登录名称查询登录用户
        User existU = ud.getByUserCode(u.getUser_code());
        //2,判断用户是否存在,不存在=>抛出异常,提示用户名不存在
        if (existU == null) {
            throw new RuntimeException("用户名不存在!");
        }
        //3,判断用户密码是否正确,不正确=>抛出异常,提示密码错误
        if (!existU.getUser_password().equals(u.getUser_password())) {
            throw new RuntimeException("密码错误!");
        }
        //4,返回查询到的用户对象
        return existU;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void saveUser(User u) {
        ud.save(u);
    }

    public UserDao getUd() {
        return ud;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
