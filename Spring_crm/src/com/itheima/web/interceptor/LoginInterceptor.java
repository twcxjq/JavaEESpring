package com.itheima.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.util.Map;

/**
 * Created by tcj on 2019/6/5.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    //指定不拦截登录的方法,其他方法都拦截

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //1,获得session
        Map<String, Object> session = ActionContext.getContext().getSession();
        //2,获得登录标识
        Object object = session.get("user");
        //3,判断登录标识是否存在
        if (object == null) {
            //不存在=>没有登录=>重定向到登录页面
            return "toLogin";
        } else {
            //存在=>已经登录=>放行
            return actionInvocation.invoke();
        }
    }
}
