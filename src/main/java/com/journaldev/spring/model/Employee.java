package com.journaldev.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"Employee_name","id"})
@JsonIgnoreProperties({"dept"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
   int id;
   String dept;
   public String getDemo() {
	return demo;
}
public void setDemo(String demo) {
	this.demo = demo;
}
String demo;
   public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
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
@JsonProperty("Employee_name")
String name;
public Employee() {
	super();
}
@Override
public String toString() {
	return "Employee [id=" + id + ", dept=" + dept + ", demo=" + demo + ", name=" + name + "]";
}
public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

   
   
}
