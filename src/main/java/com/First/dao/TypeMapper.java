package com.First.dao;

import com.First.pojo.Type;
import com.First.pojo.TypeToPost;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TypeMapper {

    int addType(Type type);

    int deleteTypeById(int id);

    int updateType(Type type);

    Type queryTypeById(int id);

    List<Type> queryAllType();

    int getLastInsert();
}
