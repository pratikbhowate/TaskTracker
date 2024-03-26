package com.example.TaskTracker.service;

import com.example.TaskTracker.pojo.Users.User;

public interface UserService {
	
	User findByUsername(String username);
    User save(User user);
    
}
	

