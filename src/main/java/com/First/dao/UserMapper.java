package com.First.dao;

import com.First.pojo.User;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserMapper {

    List<User> listUser();

    User queryUserById(Integer id);

    User queryUserByName(String username);

    int addUser(User user);

    int updatePerosnalInfo(User user) throws DuplicateKeyException;

    int updateAvatar(User user);

    int updatePassword(User user);

    int updateGender(String gender);

    int  updateGrade(String gender);

    int updateMajor(String major);
}
