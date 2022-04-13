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

    int updateAvator(User user);

    int updatePassword(User user);

    String addGender(String gender);

    String deleteGender(String gender);

    String updateGender(String gender);

    String addGrade(String grade);

    String deleteGrade(String grade);

    String updateGrade(String gender);

    String addMajor(String major);

    String deleteMajor (String major);

    String updateMajor(String major);
}
