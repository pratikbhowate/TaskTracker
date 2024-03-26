package com.example.TaskTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TaskTracker.pojo.Users.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByUsername(String username);
	
	

}
