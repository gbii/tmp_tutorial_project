package com.tmp.entities;
// Generated Dec 28, 2015 2:52:47 PM by Hibernate Tools 4.3.1.Final

/**
 * Teacher generated by hbm2java
 */
public class Teacher implements java.io.Serializable {

	private long id;
	private String name;
	private String surname;

	public Teacher() {
	}

	public Teacher(long id) {
		this.id = id;
	}

	public Teacher(long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
