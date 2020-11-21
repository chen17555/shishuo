package com.czh.shishuo.TestService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.czh.shishuo.dto.UserLoginDto;
import com.czh.shishuo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
    @Autowired
    UserService userService;

    @Test
    public void testLogin(){
        UserLoginDto user = new UserLoginDto();
        user.setUserName("admin");
        user.setUserPwd("admin");
        System.out.println(userService.login(user));
    }
}
