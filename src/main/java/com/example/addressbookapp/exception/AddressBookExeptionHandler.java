package com.example.addressbookapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.addressbookapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class AddressBookExeptionHandler {
	private final String message = "Exception while processing rest request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handHttpMessageException(HttpMessageNotReadableException exception) {
		log.error("Invalid Phone no", exception);
		ResponseDTO responseDto = new ResponseDTO(message, "phone should be 10 numeric value");
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objerr -> objerr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDto = new ResponseDTO(message, errMsg);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(AddressBookException exception) {

		ResponseDTO responseDto = new ResponseDTO(message, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.BAD_REQUEST);

	}

}
