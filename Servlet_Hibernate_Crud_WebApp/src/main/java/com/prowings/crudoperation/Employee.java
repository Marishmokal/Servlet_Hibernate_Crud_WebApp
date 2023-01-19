package com.prowings.crudoperation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
int id;
String name;
String City;
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
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", City=" + City + "]";
}
public Employee() {
	// TODO Auto-generated constructor stub
}
public Employee(int id, String name, String city) {
	super();
	this.id = id;
	this.name = name;
	City = city;
}
}
