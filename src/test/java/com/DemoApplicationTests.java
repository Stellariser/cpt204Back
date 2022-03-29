package com;

import com.First.pojo.Comment;
import com.First.pojo.Post;
import com.First.pojo.Type;
import com.First.pojo.User;
import com.First.service.CommentService;
import com.First.service.CommentServiceImpl;
import com.First.service.PostServiceImpl;
import com.First.service.TypeServiceImpl;
import com.First.service.UserService;
import com.First.service.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private TypeServiceImpl typeService;
    @Autowired
    private CommentServiceImpl commentService;

    @Test
    void contextLoads() {

    }

    @Test
    public void Usertext() {

        List<User> userList = userService.listUser();
        for (User User : userList) {
            System.out.println(User);
        }
    }

    @Test
    public void Usertext2() {

        User user = userService.queryUserByName("admin");

        System.out.println(user);
        System.out.println("aaa");

    }

    @Test
    public void Posttext2() {

        List<Post> postList = postService.queryAllPost();
        for (Post post : postList) {
            System.out.println(post);
        }
    }

    @Test
    public void TypeTest() {

        Type type = new Type();
        type.setId(1);
        type.setTypeName("study");

        Assertions.assertEquals(type, typeService.queryTypeById(1));

    }

    @Test
    public void CommentTest() {
        Comment comment = new Comment();
        comment.setId(10086);
        comment.setPostId(7745);

        commentService.addComment(comment);

        Assertions.assertEquals(comment, commentService.queryCommentById(10086));

    }

    @Test
    public void UserTest() {
        User user = new User();
        user.setId(0001);
        user.setUsername("Anni");

        Assertions.assertEquals(user, commentService.queryCommentByWriterId(0001));
    }

}
