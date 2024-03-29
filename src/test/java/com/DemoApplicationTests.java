package com;

import com.First.Utils.PythonRun;
import com.First.VO.PostQueryInfo;
import com.First.VerificationCode.VerificationCodeGenerator;
import com.First.pojo.*;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import com.First.service.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    private PostLikesServiceImpl postLieksService;
    @Autowired
    private AvatarServiceImpl avatarService;
    @Autowired
    private BlockWordsServiceImpl blockWordsService;

    private com.First.BlockWordsChecher.BlockWordsHandler blockWordsHandler;

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
        user.setAvatar(1);

        userService.addUser(user);
    }

    @Test
    public void queryuserbyidUserTest4() {

        User u = userService.queryUserById(2);
        System.out.println(u);

    }

    //postTest
    @Test
    public void getPosttext2() {

        List<Post> postList = postService.queryAllPost();
        for (Post p : postList) {
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
        System.out.println(postService.getLastInsert());
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
    public void addPostTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Post post = new Post();

        post.setWriterId(1);
        post.setTitle("AWD饿啊风格啊哥");
        post.setWrittenTime(timestamp);
        post.setContent("As the title said, XXXXXX");
        post.setAnonymous(0);
        post.setIsDeleted(0);

        Assertions.assertEquals(1, postService.addPost(post));

    }

    @Test
    public void deletPostTest() {
        //发现问题，孙老师已经知道啦，可写在report中

        Assertions.assertEquals(1, postService.deletePostById(2));
    }

    @Test
    public void queryPostTest1() {

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
    public void queryPostTest2() {

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
    public void updatePostTest() {

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
    public void addTypeTest() {
        Type type = new Type();
        type.setId(10);
        type.setTypeName("Emotion");

        Assertions.assertEquals(1, typeService.addType(type));
    }

    @Test
    public void deleteTypeTest() {

        Assertions.assertEquals(1, typeService.deleteTypeById(2));

    }

    @Test
    public void updateTypeTest() {

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
    public void addCommentTest() {
        Comment comment = new Comment();
        comment.setWriterId(10002);
        comment.setPostId(3);
        comment.setContent("test2");

        Assertions.assertEquals(1, commentService.addComment(comment));
    }

    @Test
    public void deleteCommentTest() {

        Comment comment = new Comment();
        comment.setId(6);
        comment.setWriterId(10002);
        comment.setPostId(2);
        comment.setContent("Another comment");
        comment.setWrittenTime(new Date(1648524374000L));

        Assertions.assertEquals(1, commentService.deleteCommentById(6));
    }


    public void updateCommentTest() {

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
    public void queryCommentTest() {

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
    public void timestamp() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

    }

    @Test
    public void user() {
        User user = new User();
        user.setUsername("zpy");
        user.setPassword("afasgasg");
        user.setSecretAnswer("afaf");
        user.setSecretQuestion(1);
        user.setAvatar(1);
        userService.addUser(user);

    }

    @Test
    public void querypostbyid() {
        int id = 9;
        Post p = postService.queryPostById(id);
        System.out.println(p);

    }

    @Test
    public void querypostbyUserid() {
        int id = 1;
        List<Post> p = postService.queryPostByUserId(id);
        System.out.println(p);

    }

    @Test
    public void user2() {

        User u = userService.queryUserByName("zpy");
        System.out.println(u);

    }

    @Test
    public void setCommentService() {
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
    public void asfsafasf() {

//        Comment c =commentService.queryCommentById(1);
//        System.out.println(c);

        List<Comment> cl = commentService.queryCommentByPostId(3);
        System.out.println(cl);

    }

    @Test
    public void updateUser() {
        User u = new User();
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
        List<Type> t = typeService.queryAllType();
        System.out.println(t);
    }

    @Test
    public void pag() {
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

    // @Test
    // public void check() {
    //     int c = postCollectService.queryCollectCheckByPosterUserId(1,1);
    //     System.out.println(c);
    // }
    @Test
    public void check2() {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(1);
        postCollect.setCollectedBy(1);
        PostCollect res = postCollectService.queryCollectByIdandpost(postCollect);
        System.out.println(res);
    }

    @Test
    public void check3() {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(1);
        postCollect.setCollectedBy(1);
        PostCollect res = postCollectService.queryCollectById(1);
        System.out.println(res);
    }

    @Test
    public void check4() {
        PostLikes pl = new PostLikes();
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

    @Test
    public void querycol() {

        List<PostCollect> pl = postCollectService.getCollectListByUserId(1);
        System.out.println(pl);
    }

    @Test
    public void queasdsadl() {
        int id = 1;
        List<Post> post = new ArrayList<>();
        List<PostCollect> pcl = postCollectService.getCollectListByUserId(id);

        int index = 0;
        for (PostCollect pc : pcl) {
            Post p = new Post();
            p = postService.queryPostById(pc.getPostId());
            post.add(index, p);
            index++;
        }
        for (int i = 0; i < pcl.size(); i++) {
            String a = userService.queryUserById(post.get(i).getWriterId()).getUsername();
            post.get(i).setWriterName(a);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        for (int i = 0; i < pcl.size(); i++) {
            post.get(i).setDate(post.get(i).getWrittenTime().toString().substring(0, 19));
            post.get(i).setDate(sdf.format(post.get(i).getWrittenTime()));
        }
        System.out.println(post);
        Collections.reverse(post);
        System.out.println(post);

    }

    @Test
    public void avatarTest() {
        //Avatar avatar = new Avatar();

        int id = 1;
        Avatar res = avatarService.getById(id);
        System.out.println(res);


    }

    @Test
    public void addOneBlockWordsTest() {

        BlockWords words = new BlockWords();

        words.setId(1);
        words.setWord("diss");
        Assertions.assertEquals(1, blockWordsService.addOne("diss"));
    }

    @Test
    public void delOneBlockWordsTest() {

        BlockWords words = new BlockWords();

        words.setId(1);
        words.setWord("diss");
        Assertions.assertEquals(1, blockWordsService.delOne("diss"));

    }

    @Test
    public void deleteOnePostByAdmin() {

        Assertions.assertEquals(1, postService.deletePostById(2));

    }
    @Test
    public void block() {
        System.out.println(blockWordsService.listAll());
        String a = "丁真";
        blockWordsHandler.replace(a);
        System.out.println(a);


    }


    @Test
    public void flask() {
        System.out.println(blockWordsService.listAll());
        String a = "丁真";
        blockWordsHandler.replace(a);
        System.out.println(a);
    }



    @Test
    public void cmdPythonControl(){

        BufferedReader in = null;
        try{
            String [] args1 = new String[] {"python","D:\\ICS\\ModelDeploy\\ForJava\\AreaRest.py","--file ./terminal/1.png"};
            String args2 = "python AreaRest.py";

            Process proc = Runtime.getRuntime().exec("cmd /c cd /d D:\\ICS\\ModelDeploy\\ForJava && "+"python AreaRest.py &&");


            in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gbk"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine())!=null){
                sb.append(line);
            }
            proc.waitFor();
            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try{
                    in.close();
                }catch(IOException e ){
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void cmdPythonControl2() throws IOException {

        String pyPath = "D:\\ICS\\ModelDeploy\\ForJava\\AreaRest.py"; // python文件路径
        String pyEnvironment = "D:\\ICS\\anaconda\\python.exe"; // 默认为python，如果使用了anaconda创建了环境，可以找到对应的路径并替换，类似于"E:\\Anaconda3\\envs\\xxx\\python.exe"。
        PythonRun pythonRun = new PythonRun(); // 创建实例
        pythonRun.setEnvironment(pyEnvironment); // 设置环境
        pythonRun.setRoot("D:\\ICS\\ModelDeploy\\ForJava"); // 设置python项目的执行目录，若不设置，在调用了其它包时，可能会出现错误。如果没有import其它文件夹下的包或库，可以忽略。
        System.out.println(pythonRun.run(pyPath,"--file ./terminal/1.png")); // 参数为：(String path, String ...args)





    }




    @Test
    public void Springboottofalsk() throws IOException {

        FileInputStream inputStream = null;
        Base64.Encoder encoder = Base64.getEncoder();
        inputStream = new FileInputStream("D:\\Desktop\\DevelopmentEnvironment\\src\\main\\resources\\static\\img\\2022\\08\\04\\af68cbf7-70b5-4a8c-8203-56dd34c3ddb9.png");
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        inputStream.read(bytes);
        String base64Str = encoder.encodeToString(bytes);
        Map<String, Object> map = new HashMap<>();
        map.put("img",base64Str);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:5000/predict");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("img", base64Str));
        httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        CloseableHttpResponse response = client.execute(httpPost);
        String responseString = new BasicResponseHandler().handleResponse(response);
        Map<String, Object> resultmap = JSONObject.parseObject(responseString, new TypeReference<Map<String, Object>>() {});
        System.out.println(resultmap.get("Cany"));
        client.close();


    }

    @Test
    public void cmdPythonControl3() throws IOException {

        String a = new String("{\"Cany\":796.5272507897607,\"Space\":13945.041777850221,\"success\":true}");
        Map<String, Object> map = JSONObject.parseObject(a, new TypeReference<Map<String, Object>>() {});
        System.out.println(map.get("Cany"));

    }

    //netstat -ano | findstr 80
    //taskkill -PID 7936 -F


}
