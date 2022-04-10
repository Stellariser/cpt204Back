package com.First.service;

import com.First.pojo.User;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> listUser();

    User queryUserByName(String name);

    User queryUserById(Integer id);

    int addUser(User user);

    int updateInfo(User user) throws DuplicateKeyException;

    int updateAvator(User user);

    int updatePassword(User user);
}
