package com;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Comment;
import com.First.pojo.Post;
import com.First.pojo.Type;
import com.First.pojo.User;

import java.sql.Timestamp;
import java.util.Date;

import com.First.service.CommentServiceImpl;
import com.First.service.PostServiceImpl;
import com.First.service.TypeServiceImpl;
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


    }

    @Test
    public void addUserTest3() {

        User user = new User();
        user.setId(10001);
        user.setUsername("test1");
        user.setPassword("123456");
        user.setSecretQuestion(1);
        user.setSecretAnswer("SuZhou");
        user.setAvator("/a/a");

        userService.addUser(user);
    }
    @Test
    public void queryuserbyidUserTest4(){

       User u =  userService.queryUserById(2);
        System.out.println(u);

    }

//postTest
    @Test
    public void getPosttext2() {

        List<Post> postList = postService.queryAllPost();
        for (Post post : postList) {
            System.out.println(post);
        }
    }

    @Test
    public void getPosttext23() {
        PostQueryInfo postQueryInfo = new PostQueryInfo();

        postQueryInfo.setTypeList(null);

        postQueryInfo.setPageNumber(1);
        postQueryInfo.setPageSize(10);
        List<Post> postList = postService.queryGlobalPost(postQueryInfo);
        for (Post post : postList) {
            System.out.println(post);
        }
    }

    @Test
    public void addPostTest(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Post post = new Post();

        post.setWriterId(10002);
        post.setTitle("AWD饿啊风格啊哥");
        post.setWrittenTime(timestamp);
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

        Assertions.assertEquals(1, typeService.deleteTypeById(2));

    }
    @Test
    public void updateTypeTest(){

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


    public void updateCommentTest(){

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
    @Test
    public void timestamp(){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

    }

    @Test
    public void user(){
        User user = new User();
        user.setUsername("zpy");
        user.setPassword("afasgasg");
        user.setSecretAnswer("afaf");
        user.setSecretQuestion(1);
        user.setAvator("afasfasfasffdasf");
        userService.addUser(user);

    }
    @Test
    public void querypostbyid(){
       int id = 9;
       Post p =postService.queryPostById(id);
        System.out.println(p);

    }
    @Test
    public void user2(){

        User u = userService.queryUserByName("zpy");
        System.out.println(u);

    }
    @Test
    public void setCommentService(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Comment c = new Comment();
        c.setIsDeleted(0);
        c.setContent("sfasfsafasfasfsafasfasfasfasfasfasfas");
        c.setPostId(1);
        c.setWriterId(1);
        c.setKudos(0);
        c.setCriticism(0);
        c.setWrittenTime(timestamp);
        c.setUpdateTime(timestamp);
        commentService.addComment(c);

    }
    @Test
    public void asfsafasf(){

//        Comment c =commentService.queryCommentById(1);
//        System.out.println(c);

        List<Comment> cl = commentService.queryCommentByPostId(3);
        System.out.println(cl);

    }

    }
