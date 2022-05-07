package com.First.dao;

import com.First.pojo.PostLikeNotification;

import org.springframework.stereotype.Component;

@Component

public interface PostLikeNotificationMapper {

    int addLikeNotification(PostLikeNotification pLikeNotification);

    
}
