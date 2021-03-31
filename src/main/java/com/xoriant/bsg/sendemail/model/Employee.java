package com.xoriant.bsg.sendemail.model;

public class Employee {
	
	private String name;
	
	private String role;
	
	private String city;

	public Employee() {
	}

	public Employee(String name, String role, String city) {
		this.name = name;
		this.role = role;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + ", city=" + city + "]";
	}

}
