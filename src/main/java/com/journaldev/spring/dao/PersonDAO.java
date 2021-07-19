package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Person;


//changes in master
public interface PersonDAO {



	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Object[]> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public List listPersons1();
	public void hibernateEntityChecking(Person p);
	public void createDynamicQuery(List<String> list);
}
