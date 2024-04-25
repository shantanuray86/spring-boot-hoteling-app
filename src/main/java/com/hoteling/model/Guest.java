package com.hoteling.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()
public class Guest {

	@Id
	private int gid;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String phone;
	private String localdate;
	private String age;
	
	
	public Guest(int gid, String firstName, String lastName, String gender, String dob, String phone) {
		super();
		
		this.gid = gid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
	}
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLocaldate() {
		return localdate;
	}
	public void setLocaldate(String localdate) {
		this.localdate = localdate;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Guest [gid=" + gid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", phone=" + phone + ", localdate=" + localdate + "]";
	}
	
	
	
	
	
	
}
