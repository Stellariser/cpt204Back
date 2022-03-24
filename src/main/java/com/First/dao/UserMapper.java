package com.First.dao;

import com.First.pojo.User;

import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserMapper {

    List<User> listUser();

    User queryUserById(Integer id);

    User queryUserByName(String username);

    boolean addUser(User user);

}
