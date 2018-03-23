package com.durga.dao;

import com.durga.model.Student;

public interface StudentDao 
{
    public abstract boolean createStudent(Student student);
    public abstract Student getStudent(Integer studentId);
    public abstract boolean updateStudent(Integer studentId,String email);
    public abstract boolean deleteStudent(Integer studentId);
	
}
