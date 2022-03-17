package com.First.dao;

import com.First.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component

public interface UserMapper {


    List<User> listUser();

    User queryUserByid();

    User queryUserByName(String username);


}
