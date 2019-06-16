package com.itheima.dao.impl;

import com.itheima.dao.LinkManDao;
import com.itheima.domain.LinkMan;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by tcj on 2019/5/29.
 */
public class LinkManDaoImpl implements LinkManDao {

    @Override
    public void save(LinkMan linkMan) {
        //1,获得Session对象(该Session对象与当前线程进行了绑定)
        Session currentSession = HibernateUtils.getCurrentSession();
        currentSession.save(linkMan);
    }
}
