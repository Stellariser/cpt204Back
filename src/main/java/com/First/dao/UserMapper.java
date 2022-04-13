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

    int addGrade(String grade);

    int deleteGrade(String grade);

    int updateGrade(String gender);

    int addMajor(String major);

    int deleteMajor (String major);

    int updateMajor(String major);
}
