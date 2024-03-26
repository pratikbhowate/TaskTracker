package com.example.TaskTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TaskTracker.pojo.Users;

public interface UserRepository extends MongoRepository<Users, String>{
	
	Users findByUsername(String username);

}
