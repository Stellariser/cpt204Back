package com.First.dao;

import com.First.VO.PostQueryInfo;
import com.First.pojo.Post;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostMapper {

    int addPost(Post post);

    int deletePostById(int id);

    int updatePost(Post post);

    Post queryPostById(int id);

    List<Post> queryAllPost();

    List<Post> queryPostByUserId(Integer userId);

    Post queryPostByTitle(String title);

    int getLastInsert();

    List<Post> queryGlobalPost(PostQueryInfo postQueryInfo);

    //see the list of posts
    List<Post> getAllPostPresent();

    List<Post> getNoticedPosts(Integer userId);

    int clearNotification(Integer userId);
}
