package com.First.dao;

import com.First.pojo.PostCollect;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostCollectMapper {
    int collect(PostCollect postCollect);

	int cancelCollect(int id);

    int collectCheck(int id);

    int updateCollect(int postId);

    int updateCollectCancel(int postId);

    // Checking list of Collected Post
    List<PostCollect> getCollectListByUserId(int collectedBy);

    PostCollect queryCollectById(int id);

    PostCollect queryCollectByPosterUserId(int postId, int collectedBy);

    int queryCollectCheckByPosterUserId(@Param("postId") int postId, @Param("collectedBy") int collectedBy);
}
