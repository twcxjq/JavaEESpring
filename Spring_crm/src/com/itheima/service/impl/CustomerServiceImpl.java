package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by tcj on 2019/5/25.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public void save(Customer customer) {
        //获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction transaction = currentSession.beginTransaction();
        //调用dao保存客户
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        //提交事务
        transaction.commit();
    }

    @Override
    public List<Customer> getAll() {
        //获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction transaction = currentSession.beginTransaction();
        List<Customer> list = customerDao.getAll();
        //提交事务
        transaction.commit();
        return list;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        //获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction transaction = currentSession.beginTransaction();
        List<Customer> list = customerDao.getAll(dc);
        //提交事务
        transaction.commit();
        return list;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
