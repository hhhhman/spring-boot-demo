package com.demo.service;

import java.util.List;

import com.demo.bean.Users;

public interface UsersService {

    /**
     * 增加节点
     * @param users 用户对象
     */
    void addUser(Users users);

    /**
     * 查询所有用户
     * @return 查询道德节点对象数组
     */
    List<Users> findUserAll();

    /**
     * 通过id查询用户
     * @param n_id 用户的id
     * @return 查询到的用户对象
     */
    Users findUserById(Integer n_id);

    /**
     * 修改用户
     * @param users 用户信息的对象
     */
    void updateUser(Users users);

    /**
     * 通过id删除用户
     * @param n_id 用户的id
     */
    void deleteUserById(Integer n_id);
}
