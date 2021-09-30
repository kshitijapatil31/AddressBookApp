package com.example.addressbookapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="firstname Invalid")
	public String firstName;
	
	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="lastname Invalid")
    public String lastName;
	
	@NotNull(message="address should not be empty")
	public String address;
	
	@NotNull(message="city should not be empty")
	public String city;
	
	@NotNull(message="state should not be empty")
	public String state;
	
	@NotNull(message="zipcode should not be empty")
	public int zipcode;
	
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Phone No Invalid")
	public String phoneNo;
	
	@NotNull(message="relations should not be empty")
	public List<String> relations;
	
	}



