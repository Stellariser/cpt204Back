package com.First.service;

import com.First.pojo.TypeToPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeToPostService {

    int addTypeToPost(TypeToPost typeToPost);

    int deleteTypeToPostById(int id);

    int updateTypeToPost(TypeToPost typeToPost);

    TypeToPost queryTypeToPostById(int id);

    List<TypeToPost> queryAllTypeToPost();

    int getLastInsert();
}
