package com.First.service;

import com.First.VO.PostQueryInfo;
import com.First.dao.PostMapper;
import com.First.pojo.Post;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.First.VO.PageInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

    @Override
    public int deletePostById(int id) {
        return postMapper.deletePostById(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

    @Override
    public Post queryPostById(int id) {
        return postMapper.queryPostById(id);
    }

    @Override
    public List<Post> queryAllPost() {
        return postMapper.queryAllPost();
    }

    @Override
    public Post queryPostByTitle(String title) {
        return postMapper.queryPostByTitle(title);
    }

    @Override
    public List<Post> queryGlobalPost(PostQueryInfo postQueryInfo) {
        return postMapper.queryGlobalPost(postQueryInfo);
    }

    @Override
    public List<Post> queryPostByUserId(int userId) {
        return postMapper.queryPostByUserId(userId);
    }


    //see the list of posts
    //게시물 목록 조회
    @Override
    public List<Post> getAllPostPresent() {
        return postMapper.getAllPostPresent();
    }

    @Override
    public PageInfo<Post> getPostForPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("id ASC");
        try {
            List<Post> allPostList = postMapper.getAllPostPresent();
            PageInfo<Post> pageInfo = new PageInfo<>(allPostList);
            return pageInfo;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLastInsert() {
        return postMapper.getLastInsert();
    }

}
