package com.journaldev.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.model.Employee;

@RestController
public class RestController1 {
	  @ResponseBody
	    @RequestMapping(value="/getEmployee",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    public List<Employee> getEmployees(){
	    	List<Employee> list = new ArrayList();
	    	Employee e1 = new Employee();
	    	e1.setName("Ankush");
	    	e1.setDemo("demo1");
	    	Employee e2 = new Employee();
	    	e2.setName("sahil");
	    	list.add(e1);
	    	list.add(e2);
	    	return list;
	    	
	    }
	    
	    
	    @ResponseBody
	    @RequestMapping(value="/getEmployee/{name}",method = RequestMethod.GET)
	    public Employee getEmployee(@PathVariable("name")String studentName){
	    	
	    	Employee e1 = new Employee();
	    	e1.setName(studentName);
	    	e1.setDemo("Demo1");
	    	return e1;
	    	
	    	
	    }
	    
	  
	    @RequestMapping(value="/getEmployee1/{name}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Boolean> getEmployeeDetails (@PathVariable("name")String empName,@RequestBody Employee e){
	    	
	    System.out.println("Employee name :"+empName);
	    System.out.println("Employee info:"+e.getName());
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("sucess", "sucess");
	    /*return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);*/ 	
	   /* return new ResponseEntity<Boolean>(true,HttpStatus.OK); */
	    return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
	    	
	    }
	    @RequestMapping(value="/responseEntityDemo",method = RequestMethod.POST)
	    public ResponseEntity<List<Employee>>responseEntityDemo  (){
	    	
	   
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("sucess", "sucess");
	    List<Employee> list = new ArrayList();
    	Employee e1 = new Employee();
    	e1.setName("Ankush");
    	e1.setDemo("demo1");
    	Employee e2 = new Employee();
    	e2.setName("sahil");
    	list.add(e1);
    	list.add(e2);
	    /*return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);*/ 	
	   /* return new ResponseEntity<Boolean>(true,HttpStatus.OK); */
	    return new ResponseEntity<List<Employee>>(list,headers,HttpStatus.OK);
	    	
	    }
	   
	    
	    
	    @RequestMapping(value="/testRequestBody",method=RequestMethod.POST)
	    public void testRequestBody(@RequestBody Map<String,Integer>map) {
	    	System.out.println(map);
	    }
	    
	 
	    @RequestMapping(value="/testRequestParam",method=RequestMethod.GET)
	    public void testRequestParam(@RequestParam(value="filter")String filter) {
	    	System.out.println(filter);
	    }
	    
}
