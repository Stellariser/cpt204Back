package com.First.service;

import com.First.pojo.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> listUser();

    User queryUserByName(String name);

    User queryUserById(Integer id);

    boolean addUser(User user);

    int updatePerosnalInfo(User user) throws Exception;
}
