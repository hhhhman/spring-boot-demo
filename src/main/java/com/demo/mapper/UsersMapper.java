package com.demo.mapper;

import java.util.List;

import com.demo.bean.Users;
import org.apache.ibatis.annotations.*;

public interface UsersMapper {

	@Insert("insert into user(n_name,n_role,n_pwd,n_state) values(#{n_name},#{n_role},#{n_pwd},#{n_state})")
	public void insertUser(Users users);

	@Select("select n_id,n_name,n_role,n_pwd,n_state from user")
	public List<Users> selectUsersAll();

	@Select("select n_id,n_name,n_role,n_pwd,n_state from user where n_id = #{n_id}")
	public Users selectUsersById(@Param("n_id")Integer n_id);

	@Update("update user set n_name=#{n_name} ,n_role=#{n_role},n_state=#{n_state} where n_id=#{n_id}")
	public void updateUser(Users users);

	@Delete("delete from user where n_id = #{n_id}")
	public void deleteUserById(@Param("n_id")Integer n_id);
}
