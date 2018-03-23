package com.durga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.dao.StudentDao;
import com.durga.model.Student;
import com.durga.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
    private StudentDao studentDao;
	
	@Override
	public boolean createStudent(Student student) {
		
		return studentDao.createStudent(student);
	}

	@Override
	public Student getStudent(Integer studentId) {
		
		return studentDao.getStudent(studentId);
	}

	@Override
	public boolean updateStudent(Integer studentId, String email) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(studentId, email);
	}

	@Override
	public boolean deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudent(studentId);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
