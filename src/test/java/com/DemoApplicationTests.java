package com;

import com.First.pojo.Post;
import com.First.pojo.User;
import com.First.service.PostServiceImpl;
import com.First.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private PostServiceImpl postService;

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

    @Test
    public void Posttext2(){

        List<Post> postList = postService.queryAllPost();
        for (Post post : postList) {
            System.out.println(post);
        }

    }


}
