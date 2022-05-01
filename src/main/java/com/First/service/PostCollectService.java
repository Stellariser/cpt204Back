package com.First.service;

import java.util.List;

import com.First.pojo.PostCollect;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PostCollectService {

    int collect(PostCollect postCollect);

    int cancelCollect(int id);

    int collectCheck(int id);

    int updateCollect(int postId);

    int updateCollectCancel(int postId);

    List<PostCollect> getCollectListByUserId(int collectedBy);

    PostCollect queryCollectById(int id);
    
    PostCollect queryCollectByPosterUserId(int postId, int collectedBy);

    //int queryCollectCheckByPostUserId(@Param("postId") int postId, @Param("collectedBy") int collectedBy);
    int queryCollectCheckByPostUserId(PostCollect postCollect);
}
