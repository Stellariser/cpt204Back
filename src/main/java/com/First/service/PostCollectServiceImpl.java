package com.First.service;

import com.First.dao.PostCollectMapper;
import com.First.pojo.PostCollect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCollectServiceImpl implements PostCollectService{
    @Autowired
    private PostCollectMapper postCollectMapper;
    
    @Override
    public int collect(PostCollect postCollect){
        return postCollectMapper.collect(postCollect);
    }
}
