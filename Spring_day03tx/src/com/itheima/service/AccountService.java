package com.itheima.service;

/**
 * Created by tcj on 2019/6/12.
 */
public interface AccountService {

    //转账方法
    void transfer(Integer from,  Integer to, Double money);
}
