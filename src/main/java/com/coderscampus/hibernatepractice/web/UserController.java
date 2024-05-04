package com.coderscampus.hibernatepractice.web;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.hibernatepractice.domain.Account;
import com.coderscampus.hibernatepractice.domain.Address;
import com.coderscampus.hibernatepractice.domain.User;
import com.coderscampus.hibernatepractice.service.AddressService;
import com.coderscampus.hibernatepractice.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	private AddressService addressService;

	public UserController(UserService userService, AddressService addressService) {
		super();
		this.userService = userService;
		this.addressService = addressService;
	}

	@GetMapping("/users")
	public String getAllUsers(ModelMap model) {
		Set<User> users = userService.findAllOverridden();
		model.put("users", users);
		return "users";
	}
	
	@GetMapping("/users/{userId}")
	public String findById(ModelMap model, @PathVariable Long userId) {
		User user = userService.findById(userId);
		Address address = addressService.findById(userId);
		model.put("address", address);
		model.put("user", user);
		return "user";
	}
	
	@PostMapping("/users/{userId}")
	public String postUpdatedUser(User user, @PathVariable Long userId) {
		User foundUser = userService.findById(userId);
		user.setAccounts(foundUser.getAccounts());
		userService.saveUser(user);
		
		return "redirect:/users/" + user.getUserId();
	}
	
	@GetMapping("/register")
	public String getCreateUser(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String postCreatUser(User user) {
		userService.saveUser(user);
		System.out.println(user);
		return "redirect:/users";
	}
	
	@PostMapping("/users/{userId}/delete")
	public String deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "redirect:/users";
	}
}








