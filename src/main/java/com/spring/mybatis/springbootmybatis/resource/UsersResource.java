package com.spring.mybatis.springbootmybatis.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mybatis.springbootmybatis.mapper.UsersMapper;
import com.spring.mybatis.springbootmybatis.model.Users;

@RestController
@RequestMapping("rest/users")
public class UsersResource {

	private UsersMapper usersMapper;

	public UsersResource(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@GetMapping("/all")
	public List<Users> getAll(){
		return usersMapper.findAll();
	}

	@GetMapping("/update")
	public List<Users> update(){

		Users users = new Users();
		users.setName("Declan3");
		users.setSalary(100000L);

		usersMapper.insert(users);

		return usersMapper.findAll();
	}
}
