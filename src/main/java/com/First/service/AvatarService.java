package com.First.service;

import java.util.List;

import com.First.pojo.Avatar;

import org.springframework.stereotype.Service;

@Service
public interface AvatarService {
    List<Avatar> liatAll();

    Avatar getById(int id);
}
