package com.junit.service.test.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.junit.service.domain.Address;
import com.junit.service.domain.Customer;
import com.junit.service.web.AddressService;
import com.junit.service.web.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;

	@Mock
	private AddressService addressService;

	private Customer customer;
	private Address address;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customer = new Customer();
		customer.setCustomerId("customer-01");
		customer.setFirstName("satheesh");
		customer.setLastName("chepuri");
		customer.setMiddleName("venkata");
		address = new Address("KPHB", "Hyderabad", "TS", "500072");
		customer.setAddress(address);
	}

	@Test
	public void createCustomerTest() {
		System.out.println("address1--->"+customer.getAddress());
		Mockito.when(addressService.createAddress(address)).thenReturn(address);
		Customer customerTest = customerService.createCustomer(customer);
		
		System.out.println("address2--->"+customerTest.getAddress().getStreet());
		
		
		assertEquals(customer.getAddress(), customerTest.getAddress());
	}
}
