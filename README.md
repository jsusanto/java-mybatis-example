# java-spring-mybatis-example
Java Spring MyBatis (Persistence Framework) using Eclipse IDE and using MySQL

# Step 1
Create java spring template project https://start.spring.io/ <br/>

![image](https://github.com/jsusanto/java-spring-mybatis-example/assets/1523220/e69a0c57-a7a9-4575-8617-7137b576034a)

# Step 2

# Step 3
Create UsersResource - REST API web service and using the interface which we will create in the STEP 3

<pre>
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

</pre>

# Step 4
Create interface UsersMapper and using Annotation MyBatis

<pre>
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

</pre>

#Step 5
Create User Model

<pre>
package com.spring.mybatis.springbootmybatis.model;

public class Users {
	
	private String name;
	private Long salary;
	private Integer id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
</pre>

#Step 6
Add annotation @MappedTypes and @MapperScan in SpringBootMybatisApplication.java

<pre>
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
</pre>

#Step 7
Execute the SQL script using 'test' database MySQL Database for this example

#Output
![image](https://github.com/jsusanto/java-spring-mybatis-example/assets/1523220/3f430463-ffa0-4ef0-b9d8-621c59d91afb)


# Summary File Structure
![image](https://github.com/jsusanto/java-spring-mybatis-example/assets/1523220/9279bd71-d9c6-4cd7-b5d8-57b43ca4cd34)

