package com.First.service;

import com.First.pojo.PostCollect;

import org.springframework.stereotype.Service;

@Service
public interface PostCollectService {

    int collect(PostCollect postCollect);
    
}
