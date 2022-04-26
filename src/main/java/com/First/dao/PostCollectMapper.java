package com.First.dao;

import com.First.pojo.PostCollect;
import org.springframework.stereotype.Component;

@Component
public interface PostCollectMapper {
    int collect(PostCollect postCollect);
}
