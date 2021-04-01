package com.journaldev.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.gson.Gson;
import com.journaldev.spring.model.Employee;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Pojo;
import com.journaldev.spring.service.PersonService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	@ResponseBody
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public Map listPersons(Model model,HttpServletRequest request) {
		model.addAttribute("person", new Person());
		List<Person> listPersons = this.personService.listPersons();
		Map map = new HashMap();
		
		//model.addAttribute("listPersons", listPersons);
		map.put("sucess",listPersons);
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/hibernateEntityChecking", method = RequestMethod.GET)
	public Map addpersons(Model model,HttpServletRequest request) throws ParseException, JsonParseException, JsonMappingException, IOException {
		model.addAttribute("person", new Person());
		Map map = new HashMap();
		Person p = new Person();
		p.setId(20);
		p.setName("sahil");
		personService.hibernateEntityChecking(p);
		map.put("sucess","sucess");
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/persons1", method = RequestMethod.GET)
	public Map listPersons1(){
		
		List listPersons = this.personService.listPersons1();
		Map map = new HashMap();
		map.put("sucess",listPersons);
		return map;
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    @ResponseBody
	@RequestMapping(value = "/dynamicQuery", method = RequestMethod.GET)
	public Map dynamicQuery(Model model,HttpServletRequest request) throws ParseException, JsonParseException, JsonMappingException, IOException {
		model.addAttribute("person", new Person());
		Map map = new HashMap();
		personService.CreateDynamicQuery();
		map.put("sucess","sucess");
		return map;
	}
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String FirstPage() {
		return "index";
    	
	}
    @RequestMapping(value = "/returnPage", method = RequestMethod.GET)
   	public String returnPage() {
   		return "submit";
       	
   	}
    
    @RequestMapping(value = "/simpleAjax")
    @ResponseBody
   public String btnSubmit6(HttpServletRequest request) throws ParseException, JsonParseException, JsonMappingException, IOException {
    	/*String name = request.getParameter("foo");
    	String list = request.getParameter("dataList");*/
    	/*System.out.println("List is"+list);
    	Gson gson = new Gson();
    	List<List<Integer>> dataList1 = gson.fromJson(list, List.class);
    	System.out.println("Converted dataList is"+dataList1);*/
    	String testData = request.getParameter("name");
    	System.out.println("testData is:"+testData);
    	String data = request.getParameter("stringifiedData");
    	System.out.println("Data obtained is"+data);
    	Gson gson = new Gson();
    	Object obj = new JSONParser().parse(data);
    	  JSONObject jo = (JSONObject) obj;
    	  JSONArray phone = (JSONArray) jo.get("phoneNumbers");
    	  System.out.println("Phoe no is"+phone);
    	   System.out.println("Converting jsonArray to string"+phone.toJSONString());
    	   String jsonString = phone.toJSONString();
    	   ObjectMapper mapper = new ObjectMapper();
    	  // List<Pojo> participantJsonList = mapper.readValues(jsonString, new TypeReference<List<Pojo>>(){});
    	   List<Pojo> participantJsonList = mapper.readValue(jsonString, new TypeReference<List<Pojo>>(){});
           System.out.println(participantJsonList);
           for(Pojo p:participantJsonList) {
        	   System.out.println(p.getNumber());
        	   System.out.println(p.getType());
           }
    	
    	
    	
    	return "Hello";
    	
       	
   	}
    
    
    @RequestMapping(value = "/simpleAjaxJsonTesting")
    @ResponseBody
   public void btnSubmit7(HttpServletRequest request,@RequestBody String data) throws ParseException, JsonParseException, JsonMappingException, IOException {
    	
    	System.out.println("data is:"+data);
    	
    	
    }
   
    
  
    
	
}
