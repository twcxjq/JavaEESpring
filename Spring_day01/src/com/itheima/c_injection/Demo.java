package com.itheima.c_injection;

import com.itheima.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tcj on 2019/6/6.
 */
public class Demo {

    @Test
    public void fun1() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/c_injection/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user");
        //3,打印user对象
        System.out.println(u);
    }

    @Test
    public void fun2() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/c_injection/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user2");
        //3,打印user对象
        System.out.println(u);
    }

    @Test
    public void fun5() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/c_injection/applicationContext.xml");
        //2,向容器"要"cb对象
        CollectionBean cb = (CollectionBean) ac.getBean("cb");
        //3,打印cb对象
        System.out.println(cb);
    }
}
