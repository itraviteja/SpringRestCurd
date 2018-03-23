package com.durga.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.durga.exception.StudentNotFound;
import com.durga.status.ErrorMesages;
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
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public com.durga.status.Error formError(MethodArgumentNotValidException exception)
	{
		BindingResult result=exception.getBindingResult();
		com.durga.status.Error e=new com.durga.status.Error();
		e.setErrorCount("error count is "+result.getErrorCount());
		List<ErrorMesages> em=new ArrayList<>();
		ErrorMesages em1=null;
		
		List<FieldError> error=result.getFieldErrors();
		for(FieldError e1:error)
		{
			 em1=new ErrorMesages();
			
			em1.setFieldName(e1.getField());
			em1.setMessage(e1.getDefaultMessage());
			em1.setRejectedValue(e1.getRejectedValue());
			em.add(em1);
		}
		
		e.setErrorMessages(em);
		
		return e;
	}
}
