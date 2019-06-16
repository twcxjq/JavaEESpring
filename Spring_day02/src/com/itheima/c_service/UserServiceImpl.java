package com.itheima.c_service;

/**
 * Created by tcj on 2019/6/10.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("保存客户!");
    }

    @Override
    public void delete() {
        System.out.println("删除客户!");
    }

    @Override
    public void update() {
        System.out.println("更新客户!");
    }

    @Override
    public void find() {
        System.out.println("查找客户!");
    }
}
