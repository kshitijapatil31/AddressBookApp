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

@RestController
	@RequestMapping("/addressbook")
	public class AddressBookController {

		@RequestMapping(value= {"","/","/addressbook"})
		public ResponseEntity<String> getAddressBook(){
			return new ResponseEntity<String>("Get Call Success",HttpStatus.OK);
		}
		@GetMapping("/get/{addessbookId}")
		public ResponseEntity<String> getAddressBook(@PathVariable("addessbookId") int addessbookId){
			return new ResponseEntity<String>("Get Call Success for id"+addessbookId,HttpStatus.OK);

		}
		@PostMapping("/create")
		public ResponseEntity<String> addAddressBook(@RequestBody AddressBookDTO addressBookDTO){
			return new ResponseEntity<String>("created addressbook data:"+addressBookDTO,HttpStatus.OK);

		}
		@PutMapping("/update")
		public ResponseEntity<String> updateAddressBook(@RequestBody AddressBookDTO addressBookDTO){
			return new ResponseEntity<String>("update addressbook payroll data:"+addressBookDTO,HttpStatus.OK);

		}
		@DeleteMapping
		public ResponseEntity<String> deleteAddressBook(@PathVariable("Id") int addessbookId){
			return new ResponseEntity<String>("delete addressbook payroll:"+addessbookId,HttpStatus.OK);

		}
	
}
