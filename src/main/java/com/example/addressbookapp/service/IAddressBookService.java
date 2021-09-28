package com.example.addressbookapp.service;

import java.util.List;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int empId);

	AddressBookData createAddressBookData(AddressBookDTO empDTO);

	AddressBookData updateAddressBookData(AddressBookDTO empDTO);

	void deleteAddressBookData(int empId);
}
