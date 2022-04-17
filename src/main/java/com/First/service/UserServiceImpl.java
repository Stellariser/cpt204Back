package com.First.service;

import com.First.dao.UserMapper;

import com.First.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updatePerosnalInfo(User user) throws DuplicateKeyException {
        return userMapper.updatePerosnalInfo(user);
    }

    @Override
    public int updateAvator(User user) {
        return userMapper.updateAvator(user);
    };

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    };


    @Override
    public int updateGender(String gender) {return userMapper.updateGender(gender);};

    @Override
    public int updateGrade(String grade) {return userMapper.updateGrade(grade);};


    @Override
    public int updateMajor(String major) {return userMapper.updateGrade(major);};

}
