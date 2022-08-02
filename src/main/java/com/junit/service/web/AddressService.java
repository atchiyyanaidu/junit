package com.junit.service.web;

import com.junit.service.domain.Address;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

	public Address createAddress(Address address) {
		System.out.println("Addressssssssssssssssssssssssss");
		Address address1 = new Address("street", "hyderabad", "TS", "500072");
		return address1;
	}

}
