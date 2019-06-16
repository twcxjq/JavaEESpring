package com.itheima.a_jdbctemplate;


import com.itheima.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * Created by tcj on 2019/6/11.
 */

//演示JDBC模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

    @Resource(name = "userDao")
    private UserDao ud;

    @Test
    public void fun1() throws PropertyVetoException {

        //0,准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///hibernate_day01");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //1,创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        //2,书写SQL,并执行
        String sql = "insert into t_user value(null,'rose')";
        jt.update(sql);
    }

    @Test
    public void fun2() {
        User u = new User();
        u.setName("tom");
        ud.save(u);

    }

    @Test
    public void fun3() {
        User u = new User();
        u.setId(2);
        u.setName("jack");
        ud.update(u);

    }

    @Test
    public void fun4() {
        ud.dalete(2);

    }

    @Test
    public void fun5() {
        int totalCount = ud.getTotalCount();
        System.out.println(totalCount);

    }

    @Test
    public void fun6() {
        User user = ud.getById(1);
        System.out.println(user);

    }

    @Test
    public void fun7() {
        List<User> list = ud.getAll();
        System.out.println(list);

    }
}
