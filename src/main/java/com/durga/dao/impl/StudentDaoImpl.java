package com.durga.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.durga.dao.StudentDao;
import com.durga.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao 
{
	
	@Autowired
    private SessionFactory sessionFactory;
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean createStudent(Student student) 
	{
		boolean isInserted=false;
		try (Session session=sessionFactory.openSession();)
		{
			
		    session.beginTransaction();
		    Integer studentId=(Integer)session.save(student);
		   
		    session.getTransaction().commit();
		    if(studentId != null)
		    { 
		    	 isInserted=true;
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isInserted;
	}

	@Override
	public Student getStudent(Integer studentId) 
	{
		Student student=null;
	    try(Session session=sessionFactory.openSession();)
	    {
			student=session.get(Student.class, studentId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return student;
	}

	@Override
	public boolean updateStudent(Integer studentId,String email) 
	{
	      boolean isUpdated=false;	
	    try(Session session=sessionFactory.openSession();)
	    {
			Student student=session.get(Student.class, studentId);
			if(student != null)
			{
				session.beginTransaction();
				student.setEmail(email);
				session.getTransaction().commit();
				isUpdated=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return isUpdated;
	}

	@Override
	public boolean deleteStudent(Integer studentId) {
		boolean isDeleted=false;	
	    try(Session session=sessionFactory.openSession();)
	    {
			Student student=session.get(Student.class, studentId);
			if(student != null)
			{
				session.beginTransaction();
				session.delete(student);
				session.getTransaction().commit();
				isDeleted=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return isDeleted;
	}

	

}
