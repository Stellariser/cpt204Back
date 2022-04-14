package com.First.controller;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import com.First.pojo.Comment;
import com.First.pojo.User;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.First.VO.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
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

    // Write a post
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(@RequestBody Post newPost) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String title = newPost.getTitle();
        int writerId = newPost.getWriterId();
        String content = newPost.getContent();
        int anonymous = newPost.getAnonymous();

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> postMap = new HashMap<>();

        // Duplicated titles?
        Post post = new Post();
        post.setTitle(title);
        post.setWriterId(writerId);
        post.setWrittenTime(timestamp);
        post.setContent(content);
        post.setAnonymous(anonymous);
        postService.addPost(post);

        map.put("id", postService.queryPostByTitle(title).getId());
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
    public String replyWrite(int posterId,int postId,String content) throws Exception {
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

}
