package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.LinkManDao;
import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.service.LinkManService;
import com.itheima.utils.HibernateUtils;

/**
 * Created by tcj on 2019/5/29.
 */
public class LinkManServletImpl implements LinkManService {

    private CustomerDao customerDao;
    private LinkManDao linkManDao;

    @Override
    public void save(LinkMan linkMan) {
        //开启事务
        HibernateUtils.getCurrentSession().beginTransaction();
        try {
            //1,根据客户id获得客户对象
            Long cust_id = linkMan.getCust_id();
            Customer customer = customerDao.getById(cust_id);
            //2,将客户放入LinkMan中表达关系
            linkMan.setCustomer(customer);
            //3,保存LinkMan
            linkManDao.save(linkMan);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            HibernateUtils.getCurrentSession().getTransaction().rollback();
        }
        //提交事务
        HibernateUtils.getCurrentSession().getTransaction().commit();
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public LinkManDao getLinkManDao() {
        return linkManDao;
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }
}
