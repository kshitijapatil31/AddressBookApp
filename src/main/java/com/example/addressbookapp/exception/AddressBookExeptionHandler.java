package com.example.addressbookapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.addressbookapp.dto.ResponseDTO;



@ControllerAdvice
public class AddressBookExeptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO>handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError>errorList=exception.getBindingResult().getAllErrors();
	List<String>errMsg=errorList.stream().map(objerr ->objerr.getDefaultMessage()).collect(Collectors.toList());
	ResponseDTO responseDto=new ResponseDTO("Exception while prossesing rest request",errMsg);
	return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	
	
	}
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO>handleEmployeePayrollException(AddressBookException exception){
		
	ResponseDTO responseDto=new ResponseDTO("Exception while prossesing rest request",exception.getMessage());
	return new ResponseEntity<ResponseDTO>(responseDto , HttpStatus.BAD_REQUEST);
	
	
	}

}