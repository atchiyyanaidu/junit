package com.junit.service.web;

import java.util.UUID;

import com.junit.service.domain.Address;
import com.junit.service.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private AddressService addressService;

	/*
	 * public CustomerService(AddressService addressService) { // super();
	 * this.addressService = addressService; }
	 */

	public Customer createCustomer(Customer customer) {
		Customer customer1 = new Customer();
		if (customer != null) {

			customer.setCustomerId(UUID.randomUUID().toString());

			Address address = addressService.createAddress(customer.getAddress());
			customer1.setAddress(address);
			System.out.println("customer----->" + customer);
		}
		return customer1;
	}
}
