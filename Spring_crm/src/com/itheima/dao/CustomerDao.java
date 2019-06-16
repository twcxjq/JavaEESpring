package com.itheima.dao;

import com.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by tcj on 2019/5/26.
 */
public interface CustomerDao {

    //保存客户
    void save(Customer customer);
    //查询所有客户
    List<Customer> getAll();

    //根据id获得客户
    Customer getById(Long cust_id);
    //根据条件查询所有用户
    List<Customer> getAll(DetachedCriteria dc);
}
