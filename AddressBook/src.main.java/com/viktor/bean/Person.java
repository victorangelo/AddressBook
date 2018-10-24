package com.viktor.bean;

import java.util.Date;

/**
 * @author Viktor Angelutsa
 *
 */
public class Person {

	private String name;
	
	private String surname;
	
	private String gender;
	
	private Date birthDate;

	public Person(String name, String surname, String gender, Date birthDate){
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString(){
		return String.format("%s %s %s %s", this.getName(), this.getSurname(), this.getGender(), this.getBirthDate());
	}
}