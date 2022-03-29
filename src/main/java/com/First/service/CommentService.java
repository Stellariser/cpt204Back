package com.First.service;

import java.util.List;

import com.First.pojo.Comment;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    int addComment(Comment comment);

    int deleteCommentById(int id);

    int updateComment(Comment comment);

    Comment queryCommentById(int id);

    List<Comment> queryCommentByPostId(int postId);

    List<Comment> queryCommentByWriterId(int WriterId);
    
}
