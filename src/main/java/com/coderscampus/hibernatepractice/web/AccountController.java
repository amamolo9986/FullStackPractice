package com.coderscampus.hibernatepractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.hibernatepractice.domain.Account;
import com.coderscampus.hibernatepractice.domain.User;
import com.coderscampus.hibernatepractice.service.AccountService;
import com.coderscampus.hibernatepractice.service.UserService;

@Controller
public class AccountController {

	private AccountService accountService;
	private UserService userService;

	public AccountController(AccountService accountService, UserService userService) {
		super();
		this.accountService = accountService;
		this.userService = userService;
	}

	@GetMapping("/users/{userId}/accounts")
	public String getNewAccount(ModelMap model, @PathVariable Long userId) {
		Account account = new Account();
		account.setAccountName("Bank Account");
		model.put("account", account);
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts")
	public String saveNewAccount(@PathVariable Long userId, Account account) {
		User user = userService.findById(userId);
		user.setAccounts(user.getAccounts());
		account = accountService.saveNewAccount(account, user);
		return "redirect:/users/" + user.getUserId();
	}
	
	@GetMapping("/users/{userId}/accounts/{accountId}")
	public String updateAccount(ModelMap model, @PathVariable Long accountId, @PathVariable Long userId) {
		Account account = accountService.findById(accountId);
		User user = userService.findById(userId);
		model.put("account", account);
		model.put("user", user);
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts/{accountId}")
	public String updateAccount(@PathVariable Long userId, Account account) {
		User user = userService.findById(userId);
		 userService.saveUser(user);
		 accountService.updateAccount(account);
		return "redirect:/users/" + user.getUserId();
	}
	
	@PostMapping("/users/{userId}/account/{accountId}/delete")
	public String deleteBankAccount(@PathVariable Long accountId, User user) {
		Account account = accountService.findById(accountId);
	    // 1. Remove account from all associated users
	    for (User foundUser : account.getUsers()) {
	        foundUser.getAccounts().remove(account); // Bidirectional relationship management
	    }
	    // 2. Delete the account (JPA will handle foreign key in join table)
	    accountService.deleteBankAccount(account); 

	    return "redirect:/users/" + user.getUserId();
	}
}









