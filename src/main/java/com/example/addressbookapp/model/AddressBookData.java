package com.example.addressbookapp.model;

import java.util.List;

import com.example.addressbookapp.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBookData {

	private int addressBookId;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zipcode;
	String phoneNo;
	List<String> relations;

	public AddressBookData() {
	}

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		super();
		this.addressBookId = addressBookId;
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		this.firstName = addressBookDTO.firstName;
		this.lastName = addressBookDTO.lastName;
		this.address = addressBookDTO.address;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zipcode = addressBookDTO.zipcode;
		this.phoneNo = addressBookDTO.phoneNo;
		this.relations = addressBookDTO.relations;
	}

}
