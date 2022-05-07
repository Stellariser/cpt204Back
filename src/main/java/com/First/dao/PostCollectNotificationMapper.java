package com.First.dao;

import com.First.pojo.PostCollectNotification;

import org.springframework.stereotype.Component;

@Component
public interface PostCollectNotificationMapper {

    int addCollectNotification(PostCollectNotification postCollectNotification);

}
