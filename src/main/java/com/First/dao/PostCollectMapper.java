package com.First.dao;

import com.First.pojo.PostCollect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostCollectMapper {
    int collect(PostCollect postCollect);

	int cancelCollect(int id);

    int collectCheck(int id);

    int updateCollect(int postId);

    int updateCollectCancel(int postId);

    PostCollect queryCollectByUserId(int collectedBy);

    // Checking list of Collected Post
    List<PostCollect> getCollectListByUserId(int collectedBy);

    PostCollect queryCollectById(int id);

    // PostCollect queryCollectByPosterUserId(int postId, int collectedBy);

    //int queryCollectCheckByPosterUserId(int postId, int collectedBy);

    PostCollect queryCollectByIdandpost(PostCollect postCollect);
}
