package com.First.service;

import com.First.dao.TypeToPostMapper;
import com.First.pojo.TypeToPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeToPostServiceImpl implements TypeToPostService {
    @Autowired
    private TypeToPostMapper typeToPostMapper;

    @Override
    public int addTypeToPost(TypeToPost typeToPost) {
        return typeToPostMapper.addTypeToPost(typeToPost);
    }

    @Override
    public int deleteTypeToPostById(int id) {
        return typeToPostMapper.deleteTypeToPostById(id);
    }

    @Override
    public int updateTypeToPost(TypeToPost typeToPost) {
        return typeToPostMapper.updateTypeToPost(typeToPost);
    }

    @Override
    public TypeToPost queryTypeToPostById(int id) {
        return typeToPostMapper.queryTypeToPostById(id);
    }

    @Override
    public List<TypeToPost> queryAllTypeToPost() {
        return typeToPostMapper.queryAllTypeToPost();
    }

    @Override
    public int getLastInsert() {
        return typeToPostMapper.getLastInsert();
    }
}
