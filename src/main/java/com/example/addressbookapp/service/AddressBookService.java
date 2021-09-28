package com.example.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public List<AddressBookData> getAddressBookData() {
		 List<AddressBookData> addressBookList=new ArrayList<>();
		 addressBookList.add(new AddressBookData(1,new AddressBookDTO("kshitija", "patil","mirjole","ratnagiri","maharastra",415639,"028453145")));
		 
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int empId) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(1,new AddressBookDTO("kshitija", "patil","mirjole","ratnagiri","maharastra",415639,"028453145"));
		return addressbookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(1,addressbookDTO);
		return addressbookData;
	}

	@Override
	public AddressBookData updateAddressBookData(AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(1,addressbookDTO);
		return addressbookData;
	}

	@Override
	public void deleteAddressBookData(int empId) {
		
		
	}

}
