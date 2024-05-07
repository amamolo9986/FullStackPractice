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
	public String getAccount(ModelMap model, @PathVariable Long userId) {
		Account account = accountService.findById(userId);
		model.put("account", account);
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts")
	public String saveAccount(@PathVariable Long userId, Account account) {
		User user = userService.findById(userId);
		user.setAccounts(user.getAccounts());
		account = accountService.saveAccount(account, user);
		return "redirect:/users/" + user.getUserId();
	}

}
