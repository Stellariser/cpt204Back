package com.First.service;

import com.First.dao.TypeMapper;
import com.First.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public int deleteTypeById(int id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Type queryTypeById(int id) {
        return typeMapper.queryTypeById(id);
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.queryAllType();
    }

    @Override
    public int getLastInsert() {
        return typeMapper.getLastInsert();
    }
}
