package com.example.addressbookapp.dto;

import java.util.List;

import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="firstname Invalid")
	public String firstName;
	
	@Pattern(regexp ="^[A-Z]{1}[a-zA-z\\s]{2,}$",message="lastname Invalid")
    public String lastName;
	
	public String address;
	public String city;
	public String state;
	public int zipcode;
	public String phoneNo;
	public List<String> relations;
	
	}



