package com.First.service;

import java.util.List;

import com.First.pojo.PostCollect;

import org.springframework.stereotype.Service;

@Service
public interface PostCollectService {

    int collect(PostCollect postCollect);

    int cancelCollect(int id);

    int collectCheck(int id);

    List<PostCollect> getCollectListByUserId(int collectedBy);

    PostCollect queryCollectById(int id);
    
}
