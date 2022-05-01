package com.First.dao;

import com.First.pojo.PostLikes;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PostLikesMapper {
    int like(PostLikes postLikes);

    int cancelLike(int id);
    
    int likeCheck(int id);

    int updateLike(int postId);

    int updateLikeCancel(int postId);

    PostLikes queryLikesById(int id);

    PostLikes queryLikesByPosterUserId(int postId, int likedBy);

    int queryLikesCheckByPostUserId(@Param("postId") int postId, @Param("likedBy") int likedBy);



}
