package com.First.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.First.VO.PageInfo;
import com.First.pojo.Comment;
import com.First.pojo.Post;
import com.First.service.CommentServiceImpl;
import com.First.service.PostServiceImpl;
import com.First.service.UserServiceImpl;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserServiceImpl userService;

    // Get all comments of a post.
    @RequestMapping(value = "/getPostComment", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String getComment(int postId,int pageNumber,int pageSize) {

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> commentMap = new HashMap<>();

        Post post = postService.queryPostById(postId);

        if (post == null) {
            commentMap.put("status", "0");
            commentMap.put("msg", "The post does not exists.");
            return JSONObject.toJSONString(commentMap);
        }

        PageHelper.startPage(pageNumber, pageSize);
        List<Comment> commentList = commentService.queryCommentByPostId(postId);
        for (Comment c:commentList){
            String a = userService.queryUserById(c.getWriterId()).getUsername();
            c.setWritername(a);
        }
        if (commentList == null) {
            commentMap.put("status", "1");
            commentMap.put("msg", "The post does not have comment.");
        } else {
            PageInfo<Comment> commentInfo = new PageInfo<>(commentList);
            map.put("commentInfo", commentInfo);
            map.put("totalpage",commentInfo.getTotal());

            commentMap.put("data", map);
            commentMap.put("totalpage", commentInfo.getTotal());
            commentMap.put("status", 200);
            commentMap.put("msg", "Get comments successfully.");
        }

        return JSONObject.toJSONString(commentMap);
    }


}
