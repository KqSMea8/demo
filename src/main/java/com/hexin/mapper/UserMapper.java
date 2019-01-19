package com.hexin.mapper;

import com.hexin.entity.User;

import java.util.List;

public interface UserMapper {

    
    List<User> findAll();

    Integer insertUser(User user);

    List<User> findUserById(Integer id);

    Integer delUserById(Integer id);

    Integer updateUserById(User user);

    List<User> viewTest();

    User login(String username);

}
