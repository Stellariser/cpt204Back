package com;

import com.First.VO.PostQueryInfo;
import com.First.VerificationCode.VerificationCodeGenerator;
import com.First.pojo.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.First.service.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TypeToPostServiceImpl typeToPostService;
    @Autowired
    private PostCollectServiceImpl postCollectService;
    @Autowired
    private PostLieksServiceImpl postLieksService;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

        List<Post> postList = postService.queryAllPost();
        for(Post p :postList){
            System.out.println(p);
        }
//        for (Post post : postList) {
//            post.setDate(sdf.format(post.getWrittenTime()));
//
//            //System.out.println(post.getWrittenTime());
//            System.out.println(sdf.format(post.getWrittenTime().getTime()));
//        }
    }
    @Test
    public void getPosttext22() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分钟ss秒");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(timestamp.getTime()));

    }



    @Test
    public void getPostmax() {
        System.out.println( postService.getLastInsert());
        TypeToPost typeToPost = new TypeToPost();
        typeToPost.setPostId(38);
        typeToPost.setTypeId(1);
        typeToPostService.addTypeToPost(typeToPost);
    }

    @Test
    public void getPosttext23() {
        PostQueryInfo postQueryInfo = new PostQueryInfo();

        postQueryInfo.setTypeList(null);
        postQueryInfo.setQuery("zzz");
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

        post.setWriterId(1);
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
    public void querypostbyUserid(){
        int id = 1;
        List<Post> p =postService.queryPostByUserId(id);
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
    @Test
    public void updateUser(){
        User u  = new User();
        u.setId(1);
        u.setUsername("admin");
        u.setGrade("3");
        u.setMajor("ics");
        u.setPersonalInfo("这是一个可爱的女孩子");
        userService.updatePerosnalInfo(u);
    }
    @Test
    public void very() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map = VerificationCodeGenerator.generateCode();
        System.out.println(map);
    }
    @Test
    public void type() {
        List<Type> t= typeService.queryAllType();
        System.out.println(t);
    }

    @Test
    public void pag(){
        int pageNumber = 1;
        int pageSize = 5;
        PageHelper.startPage(pageNumber, pageSize);
        PostQueryInfo postQueryInfo = new PostQueryInfo();

        postQueryInfo.setQuery(null);

        postQueryInfo.setPageNumber(pageNumber);
        postQueryInfo.setPageSize(pageSize);

        postQueryInfo.setTypeList(null);

        List<Post> Post = postService.queryGlobalPost(postQueryInfo);
        PageInfo<Post> pageInfo = new PageInfo<>(Post);
        System.out.println(pageInfo.getPages());

    }
    @Test
    public void collectcheck() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PostCollect postCollect = new PostCollect();
        postCollect.setCollectedBy(1);
        postCollect.setCollectedTime(timestamp);
        postCollect.setPostId(2);
        postCollect.setCollectCheck(0);
        postCollectService.collect(postCollect);
    }
    @Test
    public void check() {

        int c = postCollectService.queryCollectCheckByPosterUserId(1,1);
        System.out.println(c);
    }
    @Test
    public void check2() {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(1);
        postCollect.setCollectedBy(1);
        PostCollect res= postCollectService.queryCollectByIdandpost(postCollect);
        System.out.println(res);
    }
    @Test
    public void check3() {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(1);
        postCollect.setCollectedBy(1);
        PostCollect res= postCollectService.queryCollectById(1);
        System.out.println(res);
    }
    @Test
    public void check4() {
        PostLikes pl =new PostLikes();
        pl.setLikedBy(1);
        pl.setPostId(1);

        PostLikes a = postLieksService.queryLikesByIdandpost(pl);
        System.out.println(a);
    }
    @Test
    public void cancelcollect() {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(1);
        postCollect.setCollectedBy(1);
        int a = postCollectService.cancelCollect(postCollect);
        System.out.println(a);
    }

    }
