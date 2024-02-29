package com.spring.mybatis.springbootmybatis.mapper;

import com.spring.mybatis.springbootmybatis.model.Users;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	List<Users> findAll();

	@Insert("INSERT INTO users(name, salary) VALUES(#{name}, #{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",  //To create an ID and mapped into ID (Auto Generate)
			before = false, resultType = Integer.class)
	void insert(Users users);
}
