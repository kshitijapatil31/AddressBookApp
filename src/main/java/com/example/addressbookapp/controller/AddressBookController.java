package com.example.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.model.ResponseDTO;

@RestController
	@RequestMapping("/addressbook")
	public class AddressBookController {


	@RequestMapping(value = { "", "/", "/addressbook" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData addressBookData = null;

		addressBookData = new AddressBookData(1, new AddressBookDTO("kshitija", "patil","mirjole","ratnagiri","maharastra",415639,"028453145"));
		ResponseDTO resDto = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("empId") int empId) {
		AddressBookData addressBookData = null;

		addressBookData = new AddressBookData(1,new AddressBookDTO("kshitija", "patil","mirjole","ratnagiri","maharastra",415639,"028453145"));
		ResponseDTO resDto = new ResponseDTO("Get Successful for id", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;

		addressBookData = new AddressBookData(1, addressBookDTO);
		ResponseDTO resDto = new ResponseDTO("created addressbook data:", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("addressbookId") int addressbookId,@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData=null;
		
		addressBookData=new AddressBookData(addressbookId,addressBookDTO);
		ResponseDTO resDto=new ResponseDTO("update addressbook data:",addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto,HttpStatus.OK);
		
		

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("addressbookId") int addressbookId,@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData=null;
		
		addressBookData=new AddressBookData(addressbookId,addressBookDTO);
		ResponseDTO resDto=new ResponseDTO("delete addressbook payroll:",addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto,HttpStatus.OK);
		
		
	}

	}