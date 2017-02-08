package com.crud.rest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="myemployee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class MyEmployee {

	@Id
	@GeneratedValue
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private int age;

	@Column
	private String email;

	@Column
	private String city;
        
        @Column
	private String employer;

        @Column
	private String salary;


	//setters and getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

        //constructor with fields
	public MyEmployee(long id, String name, int age, String email, String city,String employer, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.city = city;
                this.employer=employer;
                this.salary=salary;                
	}
   // constructor without fields
	public MyEmployee() {
		super();
	}

}
