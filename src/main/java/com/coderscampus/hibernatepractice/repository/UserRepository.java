package com.coderscampus.hibernatepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.hibernatepractice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
