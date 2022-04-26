package com.First.dao;

import com.First.pojo.PostLikes;
import org.springframework.stereotype.Component;

@Component
public interface PostLikesMapper {
    int like(PostLikes postLikes);
}
