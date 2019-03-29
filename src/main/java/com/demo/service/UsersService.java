package com.demo.service;

import java.util.List;

import com.demo.bean.Users;

public interface UsersService {

	public void addUser(Users users);
	public List<Users> findUserAll();
	public Users findUserById(Integer n_id);
	public void updateUser(Users users);
	public void deleteUserById(Integer n_id);
}
