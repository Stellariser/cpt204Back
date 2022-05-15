package com.First.service;

import java.util.List;

import com.First.dao.CommentMapper;
import com.First.pojo.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteCommentById(int id) {
        return commentMapper.deleteCommentById(id);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public Comment queryCommentById(int id) {
        return commentMapper.queryCommentById(id);
    }

    @Override
    public List<Comment> queryCommentByPostId(int postId) {
        return commentMapper.queryCommentByPostId(postId);
    }

    @Override
    public List<Comment> queryCommentByWriterId(int WriterId) {
        return commentMapper.queryCommentByWriterId(WriterId);
    }

    @Override
    public int updateNewComments(int postId) {
        return commentMapper.updateNewComments(postId);
    }

}
