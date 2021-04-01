package com.journaldev.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}
	
    @Override
    @Transactional
	public List listPersons1(){ 
		return this.personDAO.listPersons1();
	}
	

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		List<Object[]> obj = personDAO.listPersons();
		List<Person> per = new ArrayList();
		for(Object[]o:obj){
			Person p = new Person();
			p.setId((Integer)o[0]);
			p.setName(o[1]+"");
			per.add(p);
		}
		return per;
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	@Override
	@Transactional
	public void hibernateEntityChecking(Person p) {
		personDAO.hibernateEntityChecking(p);
		
	}

	@Override
	@Transactional
	public void CreateDynamicQuery() {
		List result = new ArrayList();
		List header = new ArrayList();
		List data1 = new ArrayList();
		List data2 = new ArrayList();
		header.add("id");
		header.add("name");
		header.add("rollno");
		
		data1.add("1");
		data1.add("Ankush");
		data1.add("101");
		
		data2.add("2");
		data2.add("sahil");
		data2.add("102");
        result.add(header);
        result.add(data1);
        result.add(data2);
        List<String> finalList = new ArrayList();
        
        StringBuffer preinsertQuery = new StringBuffer();
        preinsertQuery.append("insert into demo1(");
       List headerList = (List) result.get(0);	
       for(int i=0;i<headerList.size();i++){
    	   String val = (String) headerList.get(i);
    	   if(i==0){
    	    preinsertQuery.append(val);
    	    }else{
    	    	preinsertQuery.append(","+val);
    	    }
    	    	
       }
       preinsertQuery.append(")values(");
       for(int i=1;i<result.size();i++){
    	   List data = (List) result.get(i);
    	   
    	   StringBuffer insertQuery = new StringBuffer();
    	   insertQuery.append(preinsertQuery.toString());
    	    for(int j=0;j<headerList.size();j++){
    		   String val = (String) data.get(j);
    		   if(j==0){
    		      insertQuery.append("'"+val+"'");
    		   }else{
    			   insertQuery.append(","+"'"+val+"'");
    		   }
    		   
    		   
    		   
    	   }
    	   insertQuery.append(")");
    	   finalList.add(insertQuery.toString());
       }
       personDAO.createDynamicQuery(finalList);
       System.out.println("Done");
		
		
		
		
		
		
		
	}
	
	

}
