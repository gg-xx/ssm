package com.xcu.ssm.controller;

import com.xcu.ssm.domain.UserInfo;
import com.xcu.ssm.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class UserControllerTest {

    @Autowired
    private IUserService userService;
    @Test
    public void findAll() throws Exception {
        List<UserInfo> list = userService.findAll();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo);
        }
    }
}