package com.example.addressbookapp.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.addressbookapp.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name="address_book")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressBookId;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zipcode;
	String phoneNo;
	@ElementCollection
	@CollectionTable(name="addressbook_relation",joinColumns= @JoinColumn(name="id"))
	@Column(name="relation")
	List<String> relations;

	public AddressBookData() {
	}

	public AddressBookData( AddressBookDTO addressBookDTO) {
		
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
