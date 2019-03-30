package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.bean.Users;
import com.demo.service.UsersService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(Users users) {
        this.usersService.addUser(users);
        return "ok";
    }

    /**
     * 查询全部用户
     */
    @RequestMapping("/findUserAll")
    public List<Users> findUserAll() {
        return this.usersService.findUserAll();
    }

    /**
     * 根据用户id查询用户
     */
    @RequestMapping("/findUserById")
    public Users findUserById(Integer n_id) {
        return this.usersService.findUserById(n_id);
    }

    /**
     * 更新用户
     */
    @RequestMapping("/editUser")
    public String editUser(Users users) {
        this.usersService.updateUser(users);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delUser")
    public String delUser(Integer id) {
        this.usersService.deleteUserById(id);
        return "ok";
    }

}
