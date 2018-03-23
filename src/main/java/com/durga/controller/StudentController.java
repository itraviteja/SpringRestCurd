package com.durga.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.durga.error.ErrorMessage;
import com.durga.exception.StudentNotFound;
import com.durga.model.Student;
import com.durga.service.StudentService;
import com.durga.status.MessageStatus;


@RestController
public class StudentController 
{
	
	 @Autowired
     private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	 
	@PostMapping(name="/api/createStudent",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createStudent( @Valid @RequestBody Student student)
	{
		 MessageStatus message=new MessageStatus();
		 message.setMessage("student is unable to create");
		 
	    if(studentService.createStudent(student))
	    {
	    	message.setMessage("student is created successfully");
	    	return ResponseEntity.ok().body(message);
	    }
	    return new ResponseEntity<MessageStatus>(message,HttpStatus.BAD_REQUEST);
	}
	 @GetMapping("/api/getStudent/{studentId}")
	 public ResponseEntity<?> getStudent(@PathVariable int studentId)
	 {
		 MessageStatus message=new MessageStatus();
		 message.setMessage("no student found with id " +studentId);
		 Student student=studentService.getStudent(studentId);
		 if(student != null)
		 {
			 return ResponseEntity.ok().body(student);
		 }
		 throw new StudentNotFound("student not fount with id"+studentId);
	 }
	 @PutMapping("/api/updateStudent/{studentId}")
	 public ResponseEntity<?> updateStudent(@PathVariable int studentId,@RequestParam String email)
	 {
		 MessageStatus message=new MessageStatus();
		 message.setMessage("no student found with id " +studentId);
		 if(studentService.updateStudent(studentId, email))
		 {
			 message.setMessage("student email id is updated successfully");
			return ResponseEntity.ok().body(message);
		 }
		 throw new StudentNotFound("student not fount with id"+studentId);
	 }
	 @DeleteMapping("/api/deleteStudent/{studentId}")
	 public ResponseEntity<?> deleteStudent(@PathVariable int studentId)
	 {
		    MessageStatus message=new MessageStatus();
		    message.setMessage("no student found with id " +studentId);
		    
		   if(studentService.deleteStudent(studentId))
		   {
			   message.setMessage("student deleted successfully");
			   return  ResponseEntity.ok().body(message); 
		   }
		   
		   throw new StudentNotFound("student not fount with id"+studentId);
		   
	 }
	 
	 
	 
	
	 
}
