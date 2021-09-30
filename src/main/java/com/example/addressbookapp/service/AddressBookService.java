package com.example.addressbookapp.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
	@Autowired
	AddressBookRepository addressBookRepository;
	
	List<AddressBookData> addressBookList=new ArrayList<>();
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int addressBookId) {
		return addressBookList.stream()
				.filter(empDta->empDta.getAddressBookId()==addressBookId)
				.findFirst()
				.orElseThrow(()->new AddressBookException("Employee not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(addressbookDTO);
		addressBookList.add(addressbookData);
		log.debug("AddressBook Data"+addressbookData.toString());
		return addressBookRepository.save(addressbookData);
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