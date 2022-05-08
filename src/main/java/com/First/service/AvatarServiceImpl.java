package com.First.service;

import java.util.List;

import com.First.pojo.Avatar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.First.dao.AvatarMapper;

@Service
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    private AvatarMapper avatarMapper;

    @Override
    public List<Avatar> liatAll() {
        return avatarMapper.listAll();
    }

    @Override
    public Avatar getById(int id) {
        return avatarMapper.getById(id);
    }
    
}
