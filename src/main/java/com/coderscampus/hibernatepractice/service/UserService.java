package com.coderscampus.hibernatepractice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coderscampus.hibernatepractice.domain.User;
import com.coderscampus.hibernatepractice.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);	
	}

}
 