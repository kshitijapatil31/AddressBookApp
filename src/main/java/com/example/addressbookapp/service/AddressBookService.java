package com.example.addressbookapp.service;



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
	private AddressBookRepository addressBookRepository;
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataById(int addressBookId) {
		return addressBookRepository
				.findById(addressBookId)
				.orElseThrow(()->new AddressBookException("AddressBook not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=null;
		addressbookData=new AddressBookData(addressbookDTO);
		
		log.debug("AddressBook Data"+addressbookData.toString());
		return addressBookRepository.save(addressbookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int addressBookId,AddressBookDTO addressbookDTO) {
		AddressBookData addressbookData=this.getAddressBookDataById(addressBookId);
		addressbookData.updateAddressBookData(addressbookDTO);
		return  addressBookRepository.save(addressbookData);
		
	}

	@Override
	public void deleteAddressBookData(int addressBookId) {
		AddressBookData addressbookData=this.getAddressBookDataById(addressBookId);

		addressBookRepository.delete(addressbookData);
		
	}


}