package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by tcj on 2019/6/4.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();


    public String login() throws Exception {

        //获得Spring容器=>从application域(ServletContext域对象)中获取即可
        //1,获得ServletContext域对象(sc)
        ServletContext sc = ServletActionContext.getServletContext();
        //2,从sc(ServletContext域对象)中获得Spring容器(ApplicationContext(ac))
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //3,从Spring容器(ApplicationContext(ac))中获得UserService
        UserService us = (UserService) ac.getBean("userService");

        //1,调用service执行登录操作
        User u = us.login(user);
        //2,将返回的User对象放入session域中作为登录标识
        ActionContext.getContext().getSession().put("user", u);
        //3,重定向到项目的首页
        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
