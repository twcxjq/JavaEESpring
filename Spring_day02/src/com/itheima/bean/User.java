package com.itheima.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by tcj on 2019/6/6.
 */

//@Component("user")相当于<bean name="user" class="com.itheima.bean.User"></bean>
//@Component("user")
//    @Service("user") //service层
//    @Controller("user") //web层(MVC中的C在web环境下,指的就是Servlet或者Action)
    @Repository("user") //dao层

/*
* 从功能上来说,@Service("user") //service层 @Controller("user") //web层 @Repository("user") //dao层
* 这三个注解与@Component("user")注解从功能上来说没有任何区别,只是为了区别他们所注册的对象是属于三层架构中哪一层的对象
* */

//指定对象的作用范围:
@Scope(scopeName = "singleton")   //singleton | prototype
public class User {

    //    @Value("tom")
    private String name;
    //结论:如果注解中的属性只有一个需要赋值,并且属性的名称为value,则可以忽略value这个键的,直接书写需要赋的值
    //例如: @Value(value="18")相当于@Value("18")   @Repository(value="user")相当于@Repository("user")
    @Value("18")
    private Integer age;

    /*@Autowired  //自动装配
    //问题:如果匹配多个类型一致的依赖对象,将无法选择具体注入哪一个依赖对象
    @Qualifier("car")  //使用@Qualifier注解告诉Spring容器自动装配哪个名称的依赖对象*/

    @Resource(name = "car2")  //手动注入,指定注入哪个名称的依赖对象
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    @Value("tom")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @PostConstruct  //在对象被创建后调用,相当于配置文件中的init-method
    public void init() {
        System.out.println("我是初始化方法!");
    }

    @PreDestroy  //在对象销毁之前调用,相当于配置文件中的destroy-method
    public void destory() {
        System.out.println("我是销毁方法!");
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", car=" + car + '}';
    }
}
