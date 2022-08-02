package com.junit.service.domain;

import java.io.Serializable;

public class Customer implements Serializable{	
	
	/**
	 *
	 */
	private static final long serialVersionUID = -2079349527531345397L;
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String middleName;
	private Address address;

	public Customer() {
	}	

	public Customer(String customerId, String firstName, String lastName, String middleName, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.address = address;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", address=" + address + "]";
	}

}
