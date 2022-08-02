package com.junit.service.test.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.service.domain.Address;
import com.junit.service.domain.Customer;
import com.junit.service.web.CustomerController;
import com.junit.service.web.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	private Customer customer;
	private Address address;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
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
	void test_login() throws Exception {
		
		when(customerService.createCustomer(customer)).thenReturn(customer);

		mockMvc.perform(post("/api/customer/v1/create").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customer))).andExpect(status().isOk()).andReturn();

	}
}
