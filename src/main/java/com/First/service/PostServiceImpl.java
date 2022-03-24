package com.First.service;

import com.First.VO.PostQueryInfo;
import com.First.dao.PostMapper;
import com.First.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

    @Override
    public int deletePostById(int id) {
        return postMapper.deletePostById(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

    @Override
    public Post queryPostById(int id) {
        return postMapper.queryPostById(id);
    }

    @Override
    public List<Post> queryAllPost() {
        return postMapper.queryAllPost();
    }

    @Override
    public Post queryPostByName(String name) {
        return postMapper.queryPostByName(name);
    }

    @Override
    public List<Post> queryGlobalPost(PostQueryInfo postQueryInfo) {
        return postMapper.queryGlobalPost(postQueryInfo);
    }
}
