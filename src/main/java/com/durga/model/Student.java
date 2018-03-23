package com.durga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="student_table")
public class Student 
{
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="s_id")
      private int id;
	 
	  @Column(name="s_name")
      private String name;
	  
	  @Column(name="s_email")
      private String email;
	  
	  @Column(name="s_branch")
      private String branch;
	  
	  @Column(name="s_gender")
      private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
