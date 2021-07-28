package com.journaldev.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.journaldev.spring.model.Employee;
import com.journaldev.spring.model.Person;

@RestController
@RequestMapping("/ResfulService")
public class DemoController {
	@RequestMapping(value = "/rest1", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Employee>>Rest1(){
		HttpHeaders headers = new HttpHeaders();
		  List<Employee> employees = new ArrayList();
		  employees.add(new Employee(1,"Ankush"));
		  employees.add(new Employee(2,"Sahil"));

		  if (employees == null) {
		   return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		  }
		  headers.add("Number Of Records Found", String.valueOf(employees.size()));
		  return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);
		 }
	/* GET
	  THis is a get method
	*  */
    @SuppressWarnings("unchecked")


	  @RequestMapping(value="/rest2",method = RequestMethod.GET)
	    public void rest2() throws JsonParseException, JsonMappingException, IOException{
	    // RestTemplate restTemplate = new RestTemplate();
	     //String s =  restTemplate.getForObject("http://localhost:8080/SpringMVCHibernate/ResfulService/rest1",String.class);
	     //System.out.println(s);
	    // String getUrl = "http://localhost:8080/SpringMVCHibernate/ResfulService/rest1";
	     System.out.println("Testing listAllUsers API-----------");
         
	        RestTemplate restTemplate = new RestTemplate();
	        ObjectMapper mapper = new ObjectMapper();
	        //List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject("http://localhost:8080/SpringMVCHibernate/ResfulService/rest1", List.class);
	         String json = restTemplate.getForObject("http://localhost:8080/SpringMVCHibernate/ResfulService/rest1", String.class);
	         System.out.println(json);
	         JsonParser jsonParser = new JsonParser();
	         JsonArray arrayFromString = jsonParser.parse(json).getAsJsonArray();
	       
	         for (int i = 0; i < arrayFromString.size(); i++) {
	        	 arrayFromString.get(i);
	         }
	         
	    		 
	   }
    @RequestMapping(value="/rest3",method = RequestMethod.GET)
    public ModelAndView Rest(){
    	ModelAndView m = new ModelAndView("index1");
    	return m;
    	
    }
    @ResponseBody
   	@RequestMapping(value = "/ajaxUsingRest", method = RequestMethod.GET)
   	public Map dynamicQuery(Model model,HttpServletRequest request) throws ParseException, JsonParseException, JsonMappingException, IOException {
   		model.addAttribute("person", new Person());
   		Map map = new HashMap();
        map.put("sucess","sucess");
   		return map;
   	}
	}
  

