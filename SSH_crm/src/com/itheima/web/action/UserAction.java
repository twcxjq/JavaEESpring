package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by tcj on 2019/6/13.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login() throws Exception {
        //1,调用service执行登录逻辑
        User u = userService.getUserByCodePassword(user);
        //2,将返回的User对象放到session域中
        ActionContext.getContext().getSession().put("user", u);
        //3,重定向到项目的首页
        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
