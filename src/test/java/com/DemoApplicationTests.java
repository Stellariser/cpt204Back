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

import com.First.service.*;
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
    public void UserTest3() {

        User user = new User();
        user.setId(10001);
        user.setUsername("test1");
        user.setPassword("123456");
        user.setSecretQuestion(1);
        user.setSecretAnswer("SuZhou");

        Assertions.assertEquals(user, userService.queryUserById(10001));
    }
    @Test
    public void UserTest4(){

        User user = userService.queryUserById(10002);
              System.out.println(user);
              System.out.println("test2");

    }

//postTest
    @Test
    public void Posttext2() {

        List<Post> postList = postService.queryAllPost();
        for (Post post : postList) {
            System.out.println(post);
        }
    }

    @Test
    public void addPostTest(){

        Post post = new Post();
       // post.setId(4);
        post.setWriterId(10002);
        post.setTitle("Looking for someone to study with me.");
        post.setWrittenTime(new Date());
        post.setContent("As the title said, XXXXXX");
        post.setAnonymous(0);

        Assertions.assertEquals(1, postService.addPost(post));

    }

    @Test
    public void deletPostTest(){
        //发现问题，孙老师已经知道啦，可写在report中

        Assertions.assertEquals(1, postService.deletePostById(2));
    }

    @Test
    public void queryPostTest1(){

        Post post = new Post();
        post.setId(22);
        post.setTitle("Looking for someone to study with me.");
        post.setWriterId(10002);
        post.setContent("As the title said, XXXXXX");
        post.setWrittenTime(new Date(1648692914000L));
        post.setAnonymous(0);

        Assertions.assertEquals(post, postService.queryPostById(22));

    }


    @Test
    public void queryPostTest2(){

        Post post = new Post();
        post.setId(1);
        post.setWriterId(10001);
        post.setTitle("Looking for a study mate.");
        post.setContent("As the title said, XXXXXX");
        post.setWrittenTime(new Date(1648423223000L));
        post.setAnonymous(0);

        Assertions.assertEquals(post, postService.queryPostByTitle("Looking for a study mate."));

    }

    @Test
    public void updatePostTest(){

        Post post = new Post();
        post.setId(22);
        post.setTitle("Looking for someone to eat with me.");
        post.setWriterId(10002);
        post.setContent("As the title said, I want to eat");
        post.setWrittenTime(new Date(1648692914000L));
        post.setUpdateTime(new Date());
        post.setAnonymous(0);

        Assertions.assertEquals(1, postService.updatePost(post));

    }

//TypeTest
    @Test
    public void addTypeTest(){
        Type type = new Type();
        type.setId(10);
        type.setTypeName("Emotion");

        Assertions.assertEquals(1, typeService.addType(type));
    }

    @Test
    public void deleteTypeTest(){
    //报错
        Assertions.assertEquals(1, typeService.deleteTypeById(2));

    }
    @Test
    public void updateTypeTest(){//只有id和name，没有update_time

        Type type = new Type();
        type.setId(2);
        type.setTypeName("Eat");

        Assertions.assertEquals(1, typeService.updateType(type));

    }

    @Test
    public void TypeTest() {

        Type type = new Type();
        type.setId(1);
        type.setTypeName("Study");

        Assertions.assertEquals(type, typeService.queryTypeById(1));

    }

    @Test
    public void CommentTest() {
        List<Comment> commentForm_10001 = commentService.queryCommentByWriterId(10001);
        for (Comment comment : commentForm_10001) {
            System.out.println(comment);
        }

    }
    @Test
    public void addCommentTest(){
        Comment comment = new Comment();
        comment.setWriterId(10002);
        comment.setPostId(3);
        comment.setContent("test2");

        Assertions.assertEquals(1 , commentService.addComment(comment));
    }

    @Test
    public void deleteCommentTest(){

        Comment comment = new Comment();
        comment.setId(6);
        comment.setWriterId(10002);
        comment.setPostId(2);
        comment.setContent("Another comment");
        comment.setWrittenTime(new Date(1648524374000L));

        Assertions.assertEquals(1, commentService.deleteCommentById(6));
    }


    public void updateCommentTest(){//这种测试方法对不对？

        Comment comment = new Comment();
        comment.setId(4);
        comment.setWriterId(10001);
        comment.setPostId(2);
        comment.setContent("What about sunday.");
        comment.setWrittenTime(new Date(1648523410000L));
        comment.setWrittenTime(new Date());

        Assertions.assertEquals(1, commentService.updateComment(comment));
    }

    @Test
    public void queryCommentTest(){

        Comment comment = new Comment();
        comment.setId(3);
        comment.setWriterId(10001);
        comment.setPostId(2);
        comment.setContent("Sounds good!");
        comment.setWrittenTime(new Date(1648423479000L));
        comment.setKudos(0);

        Assertions.assertEquals(comment, commentService.queryCommentById(3));

    }

}
