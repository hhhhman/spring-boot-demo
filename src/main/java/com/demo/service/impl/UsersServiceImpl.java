package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mapper.UsersMapper;
import com.demo.bean.Users;
import com.demo.service.UsersService;

/**
 * @ClassName UsersServiceImpl
 * @Description 用户service层实现类
 * @Author hyj
 * @Date 2019/4/8 10:42
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void addUser(Users users) {
		this.usersMapper.insertUser(users);
	}

	@Override
	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}

	@Override
	public Users findUserById(Integer n_id) {
		return this.usersMapper.selectUsersById(n_id);
	}

	@Override
	public void updateUser(Users users) {
		this.usersMapper.updateUser(users);
	}

	@Override
	public void deleteUserById(Integer n_id) {
		this.usersMapper.deleteUserById(n_id);
	}
}
