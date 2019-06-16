package com.itheima.dao;

/**
 * Created by tcj on 2019/6/12.
 */
public interface AccountDao {

    //加钱
    void increaseMoney(Integer id, Double money);
    //减钱
    void decreaseMoney(Integer id, Double money);

}
