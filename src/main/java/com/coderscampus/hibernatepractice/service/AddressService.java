package com.coderscampus.hibernatepractice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coderscampus.hibernatepractice.domain.Address;
import com.coderscampus.hibernatepractice.repository.AddressRepository;

@Service
public class AddressService {
	
	private AddressRepository addressRepo;

	public AddressService(AddressRepository addressRepo) {
		super();
		this.addressRepo = addressRepo;
	}

	public Address findById(Long userId) {
		Optional<Address> userOpt = addressRepo.findById(userId);
		return userOpt.orElse(new Address());
	}

}
