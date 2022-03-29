package com.First.controller;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import com.First.service.PostService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private com.First.service.PostService postService;

    @RequestMapping(value = "/queryPost", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String queryDatasetsVague(String query, int pageNumber, int pageSize, String typeListString) {
        // 掉一个pagehelper调取分页数据
        PageHelper.startPage(pageNumber, pageSize);
        PostQueryInfo postQueryInfo = new PostQueryInfo();
        postQueryInfo.setQuery(query);
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
        data.put("totalpage", pageInfo.getTotal());
        data.put("pagenum", pageInfo.getPageNum());
        data.put("Posts", pageInfo.getList());
        meta.put("msg", "获取成功");
        meta.put("status", "200");
        System.out.println(resultMap);
        // return pageInfo;
        return JSONObject.toJSONString(resultMap);
    }

    //display list of post
    @RequestMapping(value = "/list", produces = "text/html;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Post> list(@RequestParam(value="pageNo",defaultValue="1")int pageNo, @RequestParam(value="pageSize",defaultValue="10")int pageSize){

            PageInfo<Post> page = postService.getPostForPage(pageNo,pageSize);
            return  page;
    }
}
