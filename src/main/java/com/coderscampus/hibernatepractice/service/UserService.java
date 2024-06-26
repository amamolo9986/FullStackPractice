package com.coderscampus.hibernatepractice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.coderscampus.hibernatepractice.domain.Address;
import com.coderscampus.hibernatepractice.domain.User;
import com.coderscampus.hibernatepractice.repository.AccountRepository;
import com.coderscampus.hibernatepractice.repository.AddressRepository;
import com.coderscampus.hibernatepractice.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private AddressRepository addressRepo;

	public UserService(UserRepository userRepo, AddressRepository addressRepo) {
		super();
		this.userRepo = userRepo;
		this.addressRepo = addressRepo;
	}

	public Set<User> findAllOverridden(){
		return userRepo.findAllOverridden();
	}
	
	public User findById(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User saveUser(User user) {
//		if(user.getUserId()==null) {
//			Account checking = new Account();
//			checking.setAccountName("Account 1");
//			checking.getUsers().add(user);
//			user.getAccounts().add(checking);
//			accountRepo.save(checking);
//		}
		return userRepo.save(user);
	}

	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);	
	}
	
	//Example Query methods from the user Repo below.
	
	public List<User> findByUsername(String username){
		return userRepo.findByUsername(username);
	}
	
	public List<User> findByUsernameAndName(String username, String name){
		return userRepo.findByUsernameAndName(username, username);
	}
	
	public List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2){
		return userRepo.findByCreatedDateBetween(date1, date2);
	}
	
	//Example Custom Query below
	
	public User findOneUserByUsername(String username) {
		return userRepo.findOneUserByUsername(username);
	}

	public User saveAddressToUser(User user, Address address) {
		user.setAddress(address);
		address.setUser(user);
		addressRepo.save(address);
		return userRepo.save(user);
	}

}
 