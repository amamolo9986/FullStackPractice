package com.coderscampus.hibernatepractice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.hibernatepractice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//select * from users where username = :username
	List<User> findByUsername(String username);
	
	//select * from users where name = :name
	List<User> findByName(String name);
	
	//select * from users where username = :username and name = :name
	List<User> findByUsernameAndName(String username, String name);
	
	//this one shows an example of creating a query method containing a range
	List<User >findByCreatedDateBetween(LocalDate date1, LocalDate date2);
	
	//Custom Query example
	@Query("select u from User u where username = :username")
	User findOneUserByUsername(String username);
}
