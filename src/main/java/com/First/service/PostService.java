package com.First.service;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    int addPost(Post post);

    int deletePostById(int id);

    int updatePost(Post post);

    Post queryPostById(int id);

    List<Post> queryAllPost();

    Post queryPostByName(String name);

    List<Post> queryGlobalPost(PostQueryInfo postQueryInfo);
}
