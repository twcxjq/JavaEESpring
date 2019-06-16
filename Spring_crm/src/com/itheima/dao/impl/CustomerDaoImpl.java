package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by tcj on 2019/5/26.
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save(Customer customer) {
        //获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //执行保存
        currentSession.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        //1,获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //2,创建Criteria对象
        Criteria criteria = currentSession.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        return list;

    }

    @Override
    public Customer getById(Long cust_id) {
        //1,获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, cust_id);
        return customer;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        //1,获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        //2,将离线对象关联到Criteria
        Criteria executableCriteria = dc.getExecutableCriteria(currentSession);
        //3，执行查询并返回
        return executableCriteria.list();
    }
}
