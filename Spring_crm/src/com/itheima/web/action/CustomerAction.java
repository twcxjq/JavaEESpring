package com.itheima.web.action;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by tcj on 2019/6/1.
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    private Customer customer = new Customer();

    public String list() throws Exception {

        //获得Spring容器=>从application域(ServletContext域对象)中获取即可
        //1,获得ServletContext域对象(sc)
        ServletContext sc = ServletActionContext.getServletContext();
        //2,从sc(ServletContext域对象)中获得Spring容器(ApplicationContext(ac))
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //3,从Spring容器(ApplicationContext(ac))中获得CustomerService
        CustomerService cs = (CustomerService) ac.getBean("customerService");

        //-------------------------------------------------------------------------------
        //1,接收参数
        String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
        //2,创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        //3,判断参数拼装条件
        if (StringUtils.isNotBlank(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
        }
        //4,调用service将离线对象传递
        List<Customer> list = cs.getAll(dc);
        //5,将返回的list放入到request域中,转发到list.jsp显示
//        ServletActionContext.getRequest().setAttribute("list", list);

        //这里不仅可以将返回的list放到ActionContext中,还可以将返回的list放到Root中(不推荐)

        //放到ActionContext(主流方法)
        ActionContext.getContext().put("list", list); //该行代码表示将返回的list放入到request域中

        return "list";
    }

    //添加客户
    public String add() throws Exception {

        //获得Spring容器=>从application域(ServletContext域对象)中获取即可
        //1,获得ServletContext域对象(sc)
        ServletContext sc = ServletActionContext.getServletContext();
        //2,从sc(ServletContext域对象)中获得Spring容器(ApplicationContext(ac))
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //3,从Spring容器(ApplicationContext(ac))中获得CustomerService
        CustomerService cs = (CustomerService) ac.getBean("customerService");

        //1,调用service
        cs.save(customer);
        //2,重定向到列表action方法
        /*
        * Struts2开发规范:
        * 转发到: return "list";
        * 重定向到*** :  return "to***";
        * */
        return "toList";
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
