package com.demo.mapper;

import java.util.List;

import com.demo.bean.Users;
import org.apache.ibatis.annotations.*;

public interface UsersMapper {

	/**
	 * 插入用户
	 * @param users 要插入的用户信息对象
	 */
	@Insert("insert into user(n_name,n_role,n_pwd,n_state) values(#{n_name},#{n_role},#{n_pwd},#{n_state})")
	 void insertUser(Users users);

	/**
	 * 查询所有的用户
	 * @return 查询到的用户的表
	 */
	@Select("select n_id,n_name,n_role,n_pwd,n_state from user")
	 List<Users> selectUsersAll();

	/**
	 * 通过id查询用户
	 * @param n_id 用户的id
	 * @return 查询到的节点对象
	 */
	@Select("select n_id,n_name,n_role,n_pwd,n_state from user where n_id = #{n_id}")
	 Users selectUsersById(@Param("n_id")Integer n_id);

	/**
	 * 修改用户信息
	 * @param users 需要修改的用户对象
	 */
	@Update("update user set n_name=#{n_name} ,n_role=#{n_role},n_state=#{n_state} where n_id=#{n_id}")
	 void updateUser(Users users);

	/**
	 * 删除节点
	 * @param n_id 需要删除的节点的id
	 */
	@Delete("delete from user where n_id = #{n_id}")
	 void deleteUserById(@Param("n_id")Integer n_id);
}
