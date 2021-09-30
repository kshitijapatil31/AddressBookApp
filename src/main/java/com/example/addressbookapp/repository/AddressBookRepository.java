package com.example.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbookapp.model.AddressBookData;

public interface AddressBookRepository   extends JpaRepository<AddressBookData ,Integer> {

}
