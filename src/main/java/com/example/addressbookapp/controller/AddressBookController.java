package com.example.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.addressbookapp.service.IAddressBookService;
import com.example.addressbookapp.dto.ResponseDTO;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value = { "", "/", "/addressbook" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> empDataList = null;

		empDataList = addressBookService.getAddressBookData();
		ResponseDTO resDto = new ResponseDTO("Get Call Success", empDataList);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@GetMapping("/get/{addressbookId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("addressbookId") int addressbookId) {
		AddressBookData addressBookData = null;

		addressBookData = addressBookService.getAddressBookDataById(addressbookId);
		ResponseDTO resDto = new ResponseDTO("Get Successful for id", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;

		addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO resDto = new ResponseDTO("created addressbook data:", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("addressbookId") int addressbookId,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;

		addressBookData = addressBookService.updateAddressBookData(addressbookId,addressBookDTO);
		ResponseDTO resDto = new ResponseDTO("update addressbook data:", addressBookData);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("addressbookId") int addressbookId,
			@RequestBody AddressBookDTO addressBookDTO) {

		addressBookService.deleteAddressBookData(addressbookId);
		ResponseDTO resDto = new ResponseDTO("delete addressbook payroll:", addressbookId);
		return new ResponseEntity<ResponseDTO>(resDto, HttpStatus.OK);

	}

}