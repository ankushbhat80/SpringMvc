<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
 
	<center>
		<h2>Hello World</h2>
		<h3>
			<a href="hello?name=Eric">Click Here</a>
		</h3>
		<button id="btnSubmit">B1</button>
		<button id="btnSubmit2">B2</button>
		<button id="btnSubmit3">B3</button>
		<button id="btnSubmit4">B4</button>
		<button id="btnSubmit5">B5</button>
		<button id="btnSubmit6">JsonTesting</button>
		<button id="btnSubmit7">JsonTestingStringify</button>
		<form action="returnPage">
           <input type="submit" value="Go to Google" />
		</form>
		
		<a href="/SpringMVCHibernate/ResfulService/rest1">link text</a>
		<a href = "/SpringMVCHibernate/ResfulService/rest2">link Text1</a>
		<a href = "/SpringMVCHibernate/ResfulService/rest3">Link Text 2</a>
	</center>
	<script>
$("#btnSubmit").click(function(){
	$.ajax({
		 
		  type:"GET",
		  url:  "persons",
		  async: false,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
});    
$("#btnSubmit2").click(function(){
	$.ajax({
		 
		  type:"GET",
		  url:  "persons1",
		  async: false,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
});  

$("#btnSubmit3").click(function(){
	$.ajax({
		 
		  type:"GET",
		  url:  "hibernateEntityChecking",
		  async: false,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
});    

$("#btnSubmit4").click(function(){
	$.ajax({
		 
		  type:"GET",
		  url:  "dynamicQuery",
		  async: false,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
}); 

$("#btnSubmit6").click(function(){
	var obj = { "name":"John", "age":30, "city":"New York"};
	var obj1 = {
		    "firstName": "John",
		    "lastName": "Smith",
		    "age": 25,
		    "address": {
		        "streetAddress": "21 2nd Street",
		        "city": "New York",
		        "state": "NY",
		        "postalCode": 10021
		    },
		    "phoneNumbers": [
		        {
		            "type": "home",
		            "number": "212 555-1234"
		        },
		        {
		            "type": "fax",
		            "number": "646 555-4567" 
		        }
		    ] 
		}
	var stringifyData = JSON.stringify(obj);
	var stringifyData1 = JSON.stringify(obj1);
	console.log("Strinfied data is",stringifyData);
	console.log("Strinfied data is",stringifyData1);
	var data = {stringifiedData:stringifyData};
	var data1 = {stringifiedData:stringifyData1};
	//var dataList = [[1,2,3],[3,4,5],[6,7,8]];
	/* var arr = {
			dataList: JSON.stringify(dataList),
			
	} */
	var dataTest = {name:"Ankush"};
	$.ajax({
		 
		  type:"GET",
		  url:  "simpleAjax",
          data : dataTest,
		  async: true,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
});  


$("#btnSubmit7").click(function(){
	var obj = { "name":"John", "age":30, "city":"New York"};
	//var data = {"data":JSON.stringify(obj)};
	$.ajax({
		 
		  type:"POST",
		  url:  "simpleAjaxJsonTesting",
          data : JSON.stringify(obj),
		  async: true,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
				/*$.each(data,function( index, value ) {
					  console.log(index + ": " + value);
					});*/
					
					console.log("response obtained is",data);
			},
			error : function(e) {
				console.log("ERROR obtained is", e);
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});
});      


</script>
</body>
</html>