package com.First.service;

import com.First.dao.PostLikesMapper;
import com.First.pojo.PostLikes;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLieksServiceImpl implements PostLikesService {
    @Autowired
    private PostLikesMapper postLikeMapper;

    @Override
    public int like(PostLikes postLikes){
        return postLikeMapper.like(postLikes);
    }

    @Override
    public int cancelLike(PostLikes postLikes){
        return postLikeMapper.cancelLike(postLikes);
    }

    @Override
    public int likeCheck(int id){
        return postLikeMapper.likeCheck(id);
    }

    @Override
    public int updateLike(int postId){
        return postLikeMapper.updateLike(postId);
    }

    @Override
    public int updateLikeCancel(int postId){
        return postLikeMapper.updateLikeCancel(postId);
    }

    @Override
    public  PostLikes queryLikesByUserId(int likedBy){
        return postLikeMapper.queryLikesByUserId(likedBy);
    }

    @Override
    public PostLikes queryLikesById(int id){
        return postLikeMapper.queryLikesById(id);
    }
    @Override
    public PostLikes queryLikesByPosterUserId(int postId, int likedBy){
        return postLikeMapper.queryLikesByPosterUserId(postId, likedBy);
    }

    // @Override
    // public int queryLikesCheckByPostUserId(@Param("postId") int postId, @Param("likedBy") int likedBy){
    //     return postLikeMapper.queryLikesCheckByPostUserId(postId, likedBy);
    // }
    @Override
    public PostLikes queryLikesByIdandpost(PostLikes postLikes){
        return postLikeMapper.queryLikesByIdandpost(postLikes);
    }

    //@Override
   // public PostLikes queryLikesByIdandpost(PostLikes postLikes) {
   //     return postLikeMapper.queryLikesByIdandpost(postLikes);
   // }

    @Override
    public int resumeLike(PostLikes postLikes) {
        return postLikeMapper.resumeLike(postLikes);
    }


}
