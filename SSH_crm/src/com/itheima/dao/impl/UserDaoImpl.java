package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tcj on 2019/6/14.
 */
/*
HibernateDaoSupport可以根据连接池创建HibernateTemplate模板对象,
不需要我们手动去创建HibernateTemplate模板对象,只需要我们从父类中获得
HibernateTemplate模板对象即可,而HibernateTemplate模板对象中封装着SessionFactory对象
所以我们需要为dao注入SessionFactory对象(通过HibernateTemplate模板对象实际上是通过Session操作数据库)
*/
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    @Override
    public User getByUserCode(final String usercode) {
        //HQL
        return getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where user_code = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, usercode);
                User user = (User) query.uniqueResult();
                return user;
            }
        });

        /*//Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("user_code", usercode));
        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }*/
    }

    @Override
    public void save(User u) {
        getHibernateTemplate().save(u);
    }
}
