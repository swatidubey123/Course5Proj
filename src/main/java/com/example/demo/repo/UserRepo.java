package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	List<User> findByEmail(String email);
	//User findByNamePassword(String name,String password);
	User findByNameAndPassword(String name,String password);
	
}

