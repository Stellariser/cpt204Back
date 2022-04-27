package com.First.service;

import com.First.pojo.PostLikes;

import org.springframework.stereotype.Service;

@Service
public interface PostLikesService {
    int like(PostLikes postLikes);

    int cancelLike(PostLikes postLikes);

    int updateLike(int postId);

    int updateLikeCancel(int postId);

    PostLikes queryLikesById(int id);

    
}
