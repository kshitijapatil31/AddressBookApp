package com.example.addressbookapp.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {

	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="firstname Invalid")

	public String firstName;
	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="lastname Invalid")
    public String lastName;
	public String address;
	public String city;
	public String state;
	public int zipcode;
	public String phoneNo;

	public AddressBookDTO(String firstName, String lastname, String address, String city, String state, int zipcode,
			String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNo = phoneNo;
	}


}
