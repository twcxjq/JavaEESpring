package com.itheima.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by tcj on 2019/6/12.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void increaseMoney(Integer id, Double money) {
        super.getJdbcTemplate().update("update t_account set money=money+? where id=?", money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {
        super.getJdbcTemplate().update("update t_account set money=money-? where id=?", money, id);
    }
}
