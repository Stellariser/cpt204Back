package com.First.service;

import com.First.dao.PostLikesMapper;
import com.First.pojo.PostLikes;

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
    public int cancelLike(int id){
        return postLikeMapper.cancelLike(id);
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
    public PostLikes queryLikesById(int id){
        return postLikeMapper.queryLikesById(id);
    }
    @Override
    public PostLikes queryLikesByPosterUserId(int postId, int likedBy){
        return postLikeMapper.queryLikesByPosterUserId(postId, likedBy);
    }
    
}
