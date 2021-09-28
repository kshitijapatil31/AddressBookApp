package com.example.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {
	 List<AddressBookData> addressBookList=new ArrayList<>();
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int addressBookId) {
		return addressBookList.get(addressBookId-1);
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(addressBookList.size()-1,addressbookDTO);
		addressBookList.add(addressbookData);
		return addressbookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int addressBookId,AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=this.getAddressBookDataById(addressBookId);
		addressbookData.setFirstName(addressbookDTO.firstName);
		addressbookData.setLastName(addressbookDTO.lastName);
		addressbookData.setCity(addressbookDTO.city);
		addressbookData.setState(addressbookDTO.state);
		addressbookData.setPhoneNo(addressbookDTO.phoneNo);
		addressBookList.set(addressBookId-1, addressbookData);
		return addressbookData;
	}

	@Override
	public void deleteAddressBookData(int addressBookId) {
		addressBookList.remove(addressBookId-1);
		
	}


}