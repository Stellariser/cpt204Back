package com.First.dao;

import com.First.pojo.TypeToPost;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TypeToPostMapper {

    int addTypeToPost(TypeToPost typeToPost);

    int deleteTypeToPostById(int id);

    int updateTypeToPost(TypeToPost typeToPost);

    TypeToPost queryTypeToPostById(int id);

    List<TypeToPost> queryAllTypeToPost();

    int getLastInsert();

}
