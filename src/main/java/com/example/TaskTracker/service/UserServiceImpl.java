package com.example.TaskTracker.service;

import org.springframework.stereotype.Service;

import com.example.TaskTracker.pojo.Users.User;
import com.example.TaskTracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	 private final UserRepository userRepository;

	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @Override
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    @Override
	    public User save(User user) {
	        return userRepository.save(user);
	    }


}
