package com.coderscampus.hibernatepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.hibernatepractice.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
