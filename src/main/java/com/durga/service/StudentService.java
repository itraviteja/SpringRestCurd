package com.durga.service;

import com.durga.model.Student;

public interface StudentService 
{
	public abstract boolean createStudent(Student student);
    public abstract Student getStudent(Integer studentId);
    public abstract boolean updateStudent(Integer studentId,String email);
    public abstract boolean deleteStudent(Integer studentId);
}
