package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Created by tcj on 2019/5/25.
 */
public class HibernateUtils {

//    private static SessionFactory sessionFactory = null;
    private static SessionFactory sessionFactory = null;
    private static Configuration conf = null;


    //静态代码块(静态代码块随着类的加载而执行,且执行一次)
    static {   //在一次虚拟机运行期间,一个类只会被加载一次,所以静态代码块只执行一次
        //1,创建,调用空参构造
        conf = new Configuration().configure();
        //2,根据配置信息,创建 SessionFactory对象
        sessionFactory = conf.buildSessionFactory();
    }

    /*
    static代码块只执行一次原因：
　　　　　　static代码块只在类加载时执行，类是用类加载器来读取的，类加载器是带有一个缓存区的，
　　　　　　它会把读取到的类缓存起来，所以在一次虚拟机运行期间，一个类只会被加载一次，这样的话
　　　　　　静态代码块只会运行一次
     */

    //获得session => 获得全新session
    public static Session openSession() {
        //3,获得session对象
        Session session = sessionFactory.openSession();
        return session;
    }
    //获得session => 获得与线程绑定的session
    public static Session getCurrentSession() {
        //3,获得session对象
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public static void main(String[] args) {
//        System.out.println(openSession());
        System.out.println(HibernateUtils.openSession());
    }
}
