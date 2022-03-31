package com.First.controller;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import com.First.service.PostService;
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

import ch.qos.logback.classic.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //Write a post
    //View Writing a post Page
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{

	}
    
	//Write a post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@RequestBody Post newPost) throws Exception{
        String title = newPost.getTitle();
        int writerId = newPost.getWriterId();
        Date writtenTime = newPost.getWrittenTime();
        String content = newPost.getContent();
        int anonymous = newPost.getAnonymous();
        
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> postMap = new HashMap<>();
        
        //Are we allowed to have the same title?
        Post post = new Post();
        post.setTitle(title);
        post.setWriterId(writerId);
        post.setWrittenTime(writtenTime);
        post.setContent(content);
        post.setAnonymous(anonymous);
        postService.addPost(post);
        
        map.put("id", postService.queryPostByTitle(title).getId());
        postMap.put("data", map);
        postMap.put("status", 200);
        postMap.put("msg", "Successfully Posted.");
        
		return JSONObject.toJSONString(postMap);
	}

    //Display the list of post(Paging)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public PageInfo<Post> list(@RequestParam(value="pageNo", required=false, defaultValue="1")int pageNum,
                               @RequestParam(value="pageSize",required=false, defaultValue="10")int pageSize){
            //PageHelper.startPage(pageNum, pageSize);
            //Check if pageSize is properly gotten from the URL
            System.out.println("Page size is this " + pageSize);

            PageInfo<Post> page = postService.getPostForPage(pageNum,pageSize);
            return  page;
    }

 


    
}
