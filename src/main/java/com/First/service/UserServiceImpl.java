package com.First.service;

import com.First.dao.UserMapper;

import com.First.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.listUser();
    }

    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public int updatePerosnalInfo(User user) throws Exception{
        return userMapper.updatePerosnalInfo(user);
    }
}
