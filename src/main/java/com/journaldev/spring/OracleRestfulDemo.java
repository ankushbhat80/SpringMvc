package com.journaldev.spring;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.journaldev.spring.model.Employee;

@RestController
public class OracleRestfulDemo {
	
	@RequestMapping(value="/testRestful",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String test(){
		List<Employee> list = new ArrayList();
    	Employee e1 = new Employee();
    	e1.setName("Ankush");
    	e1.setDemo("demo1");
    	Employee e2 = new Employee();
    	e2.setName("sahil");
    	list.add(e1);
    	list.add(e2);
    	System.out.println(list.toString());
    	JSONObject json = new JSONObject();
    	json.put("Student", list);
    	System.out.println(json);
    	return json.toString();
    	
		
	}

}
