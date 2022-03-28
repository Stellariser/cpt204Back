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

    Post queryPostByTitle(String title);

    List<Post> queryGlobalPost(PostQueryInfo postQueryInfo);

}
