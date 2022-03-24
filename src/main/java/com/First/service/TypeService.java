package com.First.service;

import com.First.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    int addType(Type type);

    int deleteTypeById(int id);

    int updateType(Type type);

    Type queryTypeById(int id);

    List<Type> queryAllType();

    int getLastInsert();
}
