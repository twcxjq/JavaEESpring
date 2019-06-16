package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.HibernateUtils;

/**
 * Created by tcj on 2019/6/4.
 */
public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Override
    public User login(User user) {
        //打开事务
        HibernateUtils.getCurrentSession().beginTransaction();
        //1,调用dao根据登录名获得User对象
        User exitU = ud.getByUserCode(user.getUser_code());
        //提交事务
        HibernateUtils.getCurrentSession().getTransaction().commit();
        if (exitU == null) {
            //未获得=>抛出异常提示用户名不存在
            throw new RuntimeException("用户名不存在!");
        }
        //2,比对密码是否一致
        if (!exitU.getUser_password().equals(user.getUser_password())) {
            //不一致=>抛出异常,提示密码错误
            throw new RuntimeException("密码错误!");
        }
        //3,返回数据库查询的User对象
        return exitU;
    }

    public UserDao getUd() {
        return ud;
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
