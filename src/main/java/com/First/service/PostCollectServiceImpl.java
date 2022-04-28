package com.First.service;

import java.util.List;

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

    @Override
    public int cancelCollect(int id){
        return postCollectMapper.cancelCollect(id);
    }
    @Override
    public int collectCheck(int id){
        return postCollectMapper.collectCheck(id);
    }

    @Override
    public List<PostCollect> getCollectListByUserId(int collectedBy){
        return postCollectMapper.getCollectListByUserId(collectedBy);
    }

    @Override
    public PostCollect queryCollectById(int id){
        return postCollectMapper.queryCollectById(id);
    }
}
