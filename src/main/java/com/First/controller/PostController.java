package com.First.controller;

import com.First.VO.PostQueryInfo;
import com.First.pojo.*;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {

    // String now =
    // LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd
    // HH:mm:ss"));
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Autowired
    private com.First.service.PostService postService;

    @Autowired
    private com.First.service.UserService userService;

    @Autowired
    private com.First.service.TypeService typeService;

    @Autowired
    private com.First.service.TypeToPostService typeToPostService;

    @Autowired
    private com.First.service.PostLikesService postLikesService;

    @Autowired
    private com.First.service.PostCollectService postCollectService;

    @RequestMapping(value = "/queryPost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String query, int pageNumber, int pageSize, String typeListString) {
        // 掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber, pageSize);
        PostQueryInfo postQueryInfo = new PostQueryInfo();
        if (query != null) {
            postQueryInfo.setQuery(query);
        }
        postQueryInfo.setPageNumber(pageNumber);
        postQueryInfo.setPageSize(pageSize);
        if (!typeListString.equals("[]")) {
            typeListString = typeListString.replaceAll("\\[", "");
            typeListString = typeListString.replaceAll("\\]", "");
            String[] TL = typeListString.split(",");
            int[] TLI = new int[TL.length];
            for (int i = 0; i < TL.length; i++) {
                ;
                TLI[i] = Integer.parseInt(TL[i]);
            }
            postQueryInfo.setTypeList(TLI);
        } else
            postQueryInfo.setTypeList(null);

        List<Post> Post = postService.queryGlobalPost(postQueryInfo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        for (Post c:Post){
            String a = userService.queryUserById(c.getWriterId()).getUsername();
            c.setWriterName(a);
            c.setDate(c.getWrittenTime().toString().substring(0,19));
            c.setDate(sdf.format(c.getWrittenTime()));
        }
        //Collections.reverse(Post);
        PageInfo<Post> pageInfo = new PageInfo<>(Post);
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data", data);
        resultMap.put("meta", meta);
        resultMap.put("status", 200);
        data.put("totalpage", pageInfo.getTotal());
        data.put("pagenum", pageInfo.getPageNum());
        data.put("postList", pageInfo.getList());
        meta.put("msg", "获取成功");
        meta.put("status", 200);
        System.out.println(resultMap);
        // return pageInfo;
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getPostDetail", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String getUserbyId(Integer id) {
        Post post = postService.queryPostById(id);

        User u = userService.queryUserById(post.getWriterId());
        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();
        resultMap.put("data", post);
        if (u == null) {
            resultMap.put("writer", "用户已被删除");
        } else {
            resultMap.put("writer", u.getUsername());
        }
        resultMap.put("content", post.getContent());
        resultMap.put("title", post.getTitle());
        //like
        resultMap.put("likeTotal", post.getTotalLikes());
        //collect!!
        resultMap.put("collectTotal", post.getTotalCollects());
        resultMap.put("meta", meta);
        resultMap.put("status", 200);
        meta.put("msg", "查询成功");
        meta.put("status", "200");
        return JSONObject.toJSONString(resultMap);
    }

    // Write a post
    // View Writing a post Page
    @RequestMapping(value = "/writeView", method = RequestMethod.GET)
    public void writeView() throws Exception {

    }
    @RequestMapping(value = "/querytype", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String type(){
        //int anonymous = newPost.getAnonymous();

        Map<String, Object> typemap = new HashMap<>();
        List<Type> typelist = typeService.queryAllType();
        typemap.put("data", typelist);
        typemap.put("status", 200);
        typemap.put("msg", "Successfully get type.");

        return JSONObject.toJSONString(typemap);
        // return "write";
    }
    // Write a post
    @RequestMapping(value = "/write", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String write(int id,String title,String content,String typeString) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int writerId = id;
        int tyl=0;
        //int anonymous = newPost.getAnonymous();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> postMap = new HashMap<>();
        if (!typeString.equals("")) {
            typeString = typeString.replaceAll("\\[", "");
            typeString = typeString.replaceAll("\\]", "");
            String[] TL = typeString.split(",");

            int[] TLI = new int[TL.length];
            for (int i = 0; i < TL.length; i++) {
                TLI[i] = Integer.parseInt(TL[i]);
            }
            tyl = TL.length;
        }
        int[] typeList = new int[tyl];
        if (!typeString.equals("")) {
            typeString = typeString.replaceAll("\\[", "");
            typeString = typeString.replaceAll("\\]", "");
            String[] TL = typeString.split(",");

            int[] TLI = new int[TL.length];
            for (int i = 0; i < TL.length; i++) {
                TLI[i] = Integer.parseInt(TL[i]);
            }
            for (int i = 0;i<tyl;i++){
                typeList[i] = TLI[i];
            }
        }

        // Duplicated titles?
        Post post = new Post();
        post.setTitle(title);
        post.setWriterId(writerId);
        post.setWrittenTime(timestamp);
        post.setContent(content);
        post.setIsDeleted(0);
        //post.setAnonymous(anonymous);
        postService.addPost(post);
        int newid = postService.getLastInsert();
        TypeToPost typeToPost = new TypeToPost();
        typeToPost.setPostId(newid);
        if(typeList.length>0){
            for (int i=0;i<typeList.length;i++){
                typeToPost.setTypeId(typeList[i]);
                typeToPostService.addTypeToPost(typeToPost);
            }
        }
        postMap.put("data", map);
        postMap.put("status", 200);
        postMap.put("msg", "Successfully Posted.");

        return JSONObject.toJSONString(postMap);
        // return "write";
    }

    // display list of post
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PageInfo<Post> list(@RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        // PageHelper.startPage(pageNum, pageSize);
        // Check if pageSize is properly gotten from the URL
        System.out.println("Page size is this " + pageSize);

        PageInfo<Post> page = postService.getPostForPage(pageNum, pageSize);
        return page;
    }

    @Autowired
    private com.First.service.CommentService commentService;

    // Add comment
    @RequestMapping(value = "/replyWrite",produces = "text/html;charset=utf-8" ,method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String replyWrite(int posterId,int postId,String content){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> commentMap = new HashMap<>();

        Comment comment = new Comment();
        comment.setWriterId(posterId);
        comment.setPostId(postId);
        comment.setWrittenTime(timestamp);
        comment.setUpdateTime(timestamp);
        comment.setContent(content);
        comment.setKudos(0);
        comment.setCriticism(0);
        comment.setIsDeleted(0);
        commentService.addComment(comment);

        map.put("id", commentService.queryCommentById(comment.getId()));
        map.put("status",200);
        commentMap.put("data", map);
        commentMap.put("status", 200);
        commentMap.put("msg", "Comment successfully posted.");

        return JSONObject.toJSONString(commentMap);
    }

    // All posts of a user
    @RequestMapping(value = "/getUserPost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryPostsByUserId(@RequestBody Map<String, Object> postInfoMap) {
        int userId = (int) postInfoMap.get("userId");
        int pageNumber = (int) postInfoMap.get("pageNumber");
        int pageSize = (int) postInfoMap.get("pageSize");

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> userPostMap = new HashMap<>();

        User user = userService.queryUserById(userId);
        if (user == null) {
            userPostMap.put("status", 0);
            userPostMap.put("msg", "User does not exist.");
        }
        PageHelper.startPage(pageNumber, pageSize);
        List<Post> postList = postService.queryPostByUserId(userId);
        if (postList == null) {
            userPostMap.put("status", 1);
            userPostMap.put("msg", "User has no posts.");
        } else {
            PageInfo<Post> postInfo = new PageInfo<>(postList);
            map.put("postInfo", postInfo);
            userPostMap.put("data", map);
            userPostMap.put("status", 200);
            userPostMap.put("msg", "Successfully get user posts.");
        }

        return JSONObject.toJSONString(userPostMap);
    }

    @RequestMapping(value = "/delete", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String deletePost(@RequestBody Map<String, Object> deleteForm){
        int postId = (int) deleteForm.get("postId");
        Post post = postService.queryPostById(postId);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> deleteMap = new HashMap<>();

        // Doesn't exist or has been deleted before
        if (post == null) {
            deleteMap.put("status", 0);
            deleteMap.put("msg", "Post does not exist or already deleted");
        } else {
            // set isDeleted to 1
            postService.deletePostById(postId);
            map.put("postId", postId);
            deleteMap.put("data", map);
            deleteMap.put("status", 200);
            deleteMap.put("msg", "Delete successfully");
        }
        // postId if deleted, else error code + reason
        return JSONObject.toJSONString(deleteMap);
    }

    //Like Post Check
    @RequestMapping(value = "/checkLikeCollect", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String likeCollectPostCheck(int userId, int postId){
        
        //How can we initialize these like and collect objects?
        //Because we still need to know the right userId and the postId in order to get the status of liked and collected
        //So I thought first find likes and collect done by the user and then find the matching postId with the userId
        //This should be list then? So I can find the one with the matching one?
        PostCollect postCollect = postCollectService.queryCollectByUserId(userId);
        PostLikes postLikes = postLikesService.queryLikesByUserId(userId);

        postCollectService.queryCollectByIdandpost(postCollect);
        postLikesService.queryLikesByIdandpost(postLikes);
        int likeCheck  = postLikes.getLikeCheck();
        int collectCheck = postCollect.getCollectCheck();

        User u = userService.queryUserById(userId);
        HashMap<String, Object> resultLikeCollectMap = new HashMap<>();
        HashMap<String, Object> meta = new HashMap<>();

        resultLikeCollectMap.put("data", u);
        resultLikeCollectMap.put("likeCheck", likeCheck);
        resultLikeCollectMap.put("collectCheck", collectCheck);
        
        resultLikeCollectMap.put("meta", meta);
        resultLikeCollectMap.put("status", 200);
        meta.put("msg", "Status read successfully");
        meta.put("status", "200");
        return JSONObject.toJSONString(resultLikeCollectMap);


    }

    //Like Post
    @RequestMapping(value = "/likePost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String likePost(int postId, int likedBy, int opt){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> likeMap = new HashMap<>();
        PostLikes postLikes = new PostLikes();

        //check if it is liked or not
        //int likeCheck = postLikes.getLikeCheck();

        if(opt==0){
            postLikes.setPostId(postId);
            postLikes.setLikedBy(likedBy);
            postLikes.setLikedTime(timestamp);
    
            postLikesService.like(postLikes);
            postLikesService.updateLike(postId);
            
            map.put("like_id", postLikesService.queryLikesById(postLikes.getId()));
            likeMap.put("data", map);
            likeMap.put("status", 200);
            likeMap.put("msg", "You've liked post");
        }
        else if(opt==1){
            postLikesService.cancelLike(postLikes.getId());
            postLikesService.updateLikeCancel(postId);

            map.put("like_id", postLikesService.queryLikesById(postLikes.getId()));
            likeMap.put("data", map);
            likeMap.put("status", 200);
            likeMap.put("msg", "You've canceled like");
        }
       
        return JSONObject.toJSONString(likeMap);
    }

    //Collect Post
    @RequestMapping(value = "/collectPost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String collectPost(int postId, int collectedBy, int opt){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> collectMap = new HashMap<>();
        PostCollect postCollect = new PostCollect();

        int collectCheck = postCollect.getCollectCheck();

        if(opt==0){
            postCollect.setPostId(postId);
            postCollect.setCollectedBy(collectedBy);
            postCollect.setCollectedTime(timestamp);
    
            postCollectService.collect(postCollect);
            postCollectService.updateCollect(postId);
            
            map.put("like_id", postCollectService.queryCollectById(postCollect.getId()));
            collectMap.put("data", map);
            collectMap.put("status", 200);
            collectMap.put("msg", "You've collected the post");
        }
        else if(opt==1){
            postCollectService.cancelCollect(postCollect.getId());
            postCollectService.updateCollectCancel(postId);

            map.put("like_id", postLikesService.queryLikesById(postCollect.getId()));
            collectMap.put("data", map);
            collectMap.put("status", 200);
            collectMap.put("msg", "You've canceled collecting");
        }

        return JSONObject.toJSONString(collectMap);
    }


}
