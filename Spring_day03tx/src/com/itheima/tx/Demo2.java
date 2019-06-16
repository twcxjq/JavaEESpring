package com.itheima.tx;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tcj on 2019/6/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Demo2 {

    @Resource(name = "accountService")
    private AccountService as;

    @Test
    public void fun1() {
        as.transfer(1, 2, 100d);
    }
}
