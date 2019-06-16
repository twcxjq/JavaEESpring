package com.itheima.a_annotation;

import com.itheima.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tcj on 2019/6/6.
 */
public class Demo {

    @Test
    public void fun1() {
        //1,创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2,向容器"要"user对象
        User u1 = (User) ac.getBean("user");
        User u2 = (User) ac.getBean("user");
        System.out.println(u1 == u2);
        //3,打印user对象
        System.out.println(u1);
        ac.close();
    }
}
