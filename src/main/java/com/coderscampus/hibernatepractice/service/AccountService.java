package com.coderscampus.hibernatepractice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coderscampus.hibernatepractice.domain.Account;
import com.coderscampus.hibernatepractice.domain.User;
import com.coderscampus.hibernatepractice.repository.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepo;
	private UserService userService;

	public AccountService(AccountRepository accountRepo, UserService userService) {
		super();
		this.accountRepo = accountRepo;
		this.userService = userService;
	}

	public Account findById(Long userId) {
		Optional<Account> accountOpt = accountRepo.findById(userId);
		return accountOpt.orElse(new Account());
	}

	public Account saveAccount(Account account, User user) {
		user.getAccounts().add(account);
		account.getUsers().add(user);
		return accountRepo.save(account);
	}



}
