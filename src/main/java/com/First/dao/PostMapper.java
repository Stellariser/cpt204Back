package com.First.dao;

import com.First.VO.Criteria;
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

    //see the list of posts
    //게시물 목록 조회
    List<Post> list(Criteria cri) throws Exception;
    //total number of posts
    int listCount();
  

}
