package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tcj on 2019/6/13.
 */
//测试Hibernate框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Test
    public void fun1() {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //-----------------------------------------------------
        User u = new User();
        u.setUser_code("tom");
        u.setUser_name("汤姆");
        u.setUser_password("1234");
        session.save(u);
        //-----------------------------------------------------
        tx.commit();
        session.close();
        sf.close();
    }

    @Test
    //测试Spring管理的SessionFactory对象
    public void fun2() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //-----------------------------------------------------
        User u = new User();
        u.setUser_code("rose");
        u.setUser_name("肉丝");
        u.setUser_password("1234");
        session.save(u);
        //-----------------------------------------------------
        tx.commit();
        session.close();
    }

    @Resource(name = "userDao")
    private UserDao ud;
    @Test
    //测试Dao HibernateTemplate模板对象
    public void fun3() {
        User user = ud.getByUserCode("tom");
        System.out.println(user);
    }

    @Resource(name = "userService")
    private UserService us;
    @Test
    //测试AOP事务
    public void fun4() {
        User u = new User();
        u.setUser_code("hqy");
        u.setUser_name("郝强勇");
        u.setUser_password("1234");

        us.saveUser(u);
    }
}
