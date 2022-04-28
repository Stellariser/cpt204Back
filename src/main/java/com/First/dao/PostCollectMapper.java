package com.First.dao;

import com.First.pojo.PostCollect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostCollectMapper {
    int collect(PostCollect postCollect);

	int cancelCollect(int id);

    int collectCheck(int id);

    // Checking list of Collected Post
    List<PostCollect> getCollectListByUserId(int collectedBy);

    PostCollect queryCollectById(int id);
}
