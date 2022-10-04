package com.marmat.dto;
public class MarksheetDTO {

	private int id;
	private String firstname;
	private String lastname;
	private String classname;
	
	public int getId() {
		return id;
	}
	public Integer setId(int id) {
		return this.id= id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String setFirstName(String firstname) {
		return this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String setLastName(String lastname) {
		return this.lastname = lastname;
	}
	public String getClassname() {
		return classname;
	}
	public String setClassname(String classname) {
		return this.classname = classname;
	
	}
	@Override
	public String toString() {
		return "MarksheetDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", classname="
				+ classname + "]";
	}
	
	}
	

