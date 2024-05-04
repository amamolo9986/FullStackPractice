package com.coderscampus.hibernatepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.hibernatepractice.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
