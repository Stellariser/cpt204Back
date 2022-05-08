package com.First.controller;

import com.First.pojo.Post;
import com.First.service.BlockWordsServiceImpl;
import com.First.service.PostServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlockWordsServiceImpl blockWordsServiceImpl;

    @Autowired
    private PostServiceImpl postService;

    @RequestMapping(value = "/addBlockWords", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String addBlockWords(String word) {
        Map<String, Object> resMap = new HashMap<>();

        try {
            blockWordsServiceImpl.addMany(word);
            resMap.put("status", 200);
            resMap.put("msg", "Successfully added block word(s)");

        } catch (Exception e) {
            resMap.put("status", 0);
            resMap.put("msg", "Failed to add block word(s)!");
        }

        return JSONObject.toJSONString(resMap);
    }

    @RequestMapping(value = "/deleteBlockWords", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public String deleteBlockWords(String word) {
        Map<String, Object> resMap = new HashMap<>();

        try {
            blockWordsServiceImpl.delMany(word);
            resMap.put("status", 200);
            resMap.put("msg", "Successfully deleted block word(s)");

        } catch (Exception e) {
            resMap.put("status", 0);
            resMap.put("msg", "Failed to delete block word(s)!");
        }

        return JSONObject.toJSONString(resMap);
    }

    @RequestMapping(value = "/deletePost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String deletePostByAdmin(int postId) {
        Post post = postService.queryPostById(postId);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> deleteMap = new HashMap<>();
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
}
