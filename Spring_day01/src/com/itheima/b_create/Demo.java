package com.itheima.b_create;

import com.itheima.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tcj on 2019/6/6.
 */
public class Demo {

    @Test
    //创建对象方式1:空参构造创建
    public void fun1() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/b_create/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user");
        //3,打印user对象
        System.out.println(u);
    }

    @Test
    //创建对象方式2:静态工厂创建
    public void fun2() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/b_create/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user2");
        //3,打印user对象
        System.out.println(u);
    }

    @Test
    //创建对象方式2:实例工厂创建
    public void fun3() {
        //1,创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/b_create/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user3");
        //3,打印user对象
        System.out.println(u);
    }

    @Test
    //测试生命周期方法
    public void fun4() {
        //1,创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/itheima/b_create/applicationContext.xml");
        //2,向容器"要"user对象
        User u = (User) ac.getBean("user3");
        //3,打印user对象
        System.out.println(u);
        //关闭容器,触发销毁方法
        ac.close();
    }
}
