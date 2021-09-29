package com.example.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//import com.example.employeepayrollapp.EmployeePayrollAppApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("address book app started in {} environment",context.getEnvironment().getProperty("Environment"));
		log.info("Addressbook DB user is {} ",context.getEnvironment().getProperty("spring.datasourse.username"));
	}

}
