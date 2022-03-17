package com;

import com.First.pojo.User;
import com.First.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

    }

    @Test
    public void Usertext(){

        List<User> userList = userService.listUser();
        for (User User : userList) {
            System.out.println(User);
        }
    }
    @Test
    public void Usertext2(){

        User user = userService.queryUserByName("admin");

        System.out.println(user);
        System.out.println("aaa");

    }


}
