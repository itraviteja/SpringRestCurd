package com.durga.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.durga.exception.StudentNotFound;
import com.durga.status.MessageStatus;

@ControllerAdvice
public class studentExceptionHandler 
{
	@ResponseBody
	@ExceptionHandler(StudentNotFound.class)
	/*@ResponseStatus(value=HttpStatus.NOT_FOUND)*/
	
	public ResponseEntity<?> studentExp(Exception e)
	{
		MessageStatus m=new MessageStatus();
		m.setMessage(e.getMessage());
		return new ResponseEntity<MessageStatus>(m,HttpStatus.NOT_FOUND);
	}
}
