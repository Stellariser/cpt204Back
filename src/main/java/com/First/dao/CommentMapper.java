package com.First.dao;

import java.util.List;

import com.First.pojo.Comment;

import org.springframework.stereotype.Component;

@Component
public interface CommentMapper {

    int addComment(Comment comment);

    int deleteCommentById(int id);

    int updateComment(Comment comment);

    Comment queryCommentById(int id);

    List<Comment> queryCommentByPostId(int postId);

    List<Comment> queryCommentByWriterId(int writerId);

    int updateNewComments(int postId);
}
