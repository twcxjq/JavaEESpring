package com.itheima.e_annotationaop;

import com.itheima.c_service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tcj on 2019/6/6.
 */
//帮助我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:com/itheima/e_annotationaop/applicationContext.xml")
public class Demo {

    //将名为userService的对象注入到us变量中
    @Resource(name = "userService")
    private UserService us;
    @Test
    public void fun1() {
        us.save();
    }

}
