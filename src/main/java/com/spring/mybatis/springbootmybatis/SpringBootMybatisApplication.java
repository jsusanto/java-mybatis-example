package com.spring.mybatis.springbootmybatis;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mybatis.springbootmybatis.model.Users;

@MappedTypes(Users.class)
@MapperScan("com.spring.mybatis.springbootmybatis.mapper") //To enable @Mapper
@SpringBootApplication
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
