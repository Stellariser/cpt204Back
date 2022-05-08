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
    public int cancelCollect(PostCollect postCollect){
        return postCollectMapper.cancelCollect(postCollect);
    }
    @Override
    public int collectCheck(int id){
        return postCollectMapper.collectCheck(id);
    }

    @Override
    public int updateCollect(int postId){
        return postCollectMapper.updateCollect(postId);
    }

    @Override
    public int updateCollectCancel(int postId){
        return postCollectMapper.updateCollectCancel(postId);
    }

    @Override
    public PostCollect queryCollectByUserId(int collectedBy) {
        return postCollectMapper.queryCollectByUserId(collectedBy);
    }

    @Override
    public List<PostCollect> getCollectListByUserId(int collectedBy){
        return postCollectMapper.getCollectListByUserId(collectedBy);
    }

    @Override
    public PostCollect queryCollectById(int id){
        return postCollectMapper.queryCollectById(id);
    }

//    @Override
//    public PostCollect queryCollectByPosterUserId(int postId, int collectedBy){
//        return postCollectMapper.queryCollectByPosterUserId(postId, collectedBy);
//    }

//    @Override
//    public int queryCollectCheckByPosterUserId(int postId, int collectedBy) {
//        return postCollectMapper.queryCollectCheckByPosterUserId(postId,collectedBy);
//    }

//    @Override
//    public int queryCollectCheckByPostUserId(@Param("postId") int postId, @Param("collectedBy") int collectedBy){
//        return postCollectMapper.queryCollectCheckByPostUserId(postId, collectedBy);
//    }

    @Override
    public PostCollect queryCollectByIdandpost(PostCollect postCollect) {
        return postCollectMapper.queryCollectByIdandpost(postCollect);
    }

    @Override
    public int resumeCollect(PostCollect postCollect) {
        return postCollectMapper.resumeCollect(postCollect);
    }
}
