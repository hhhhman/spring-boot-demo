package com.demo.service;

import java.util.List;

import com.demo.bean.Users;

public interface UsersService {

    void addUser(Users users);

    List<Users> findUserAll();

    Users findUserById(Integer n_id);

    void updateUser(Users users);

    void deleteUserById(Integer n_id);
}
