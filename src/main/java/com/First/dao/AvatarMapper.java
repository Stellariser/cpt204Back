package com.First.dao;

import java.util.List;

import com.First.pojo.Avatar;

import org.springframework.stereotype.Component;

@Component
public interface AvatarMapper {
    List<Avatar> listAll();

    Avatar getById(int id);
}
