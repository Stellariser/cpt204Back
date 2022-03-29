package com.First.service;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    int addPost(Post post);

    int deletePostById(int id);

    int updatePost(Post post);

    Post queryPostById(int id);

    List<Post> queryAllPost();

    Post queryPostByTitle(String title);

    List<Post> queryGlobalPost(PostQueryInfo postQueryInfo);

    //see the list of posts
    //게시물 목록 조회
    List<Post> getAllPostPresent();

    PageInfo<Post> getPostForPage(int pageNo, int pageSize);
  
}
