package com;

import com.First.pojo.Comment;
import com.First.pojo.Post;
import com.First.pojo.Type;
import com.First.pojo.User;
import java.util.Date;
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
        List<Comment> commentForm_10001 = commentService.queryCommentByWriterId(10001);
        for(Comment comment : commentForm_10001){
            System.out.println(comment);
        }

    }
    @Test
    public void addCommentTest(){
        Comment comment = new Comment();
        comment.setWriterId(10001);
        comment.setPostId(1);
        comment.setContent("test");
        comment.setWrittenTime(new Date());

        Assertions.assertEquals(1, commentService.addComment(comment));
    }


    @Test
    public void UserTest() {
        User user = new User();
        user.setId(10001);
        user.setUsername("test1");
        user.setPassword("123456");
        user.setSecretQuestion(1);
        user.setSecretAnswer("SuZhou");

        Assertions.assertEquals(user, commentService.queryCommentByWriterId(10001));
    }

}
