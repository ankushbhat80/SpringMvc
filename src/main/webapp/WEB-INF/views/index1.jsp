<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
<H1>Welcome to RestFul Jsp Page</H1>
<button id="btnSubmit">B1</button>
</body>
<script>
$("#btnSubmit").click(function(){
	var ctx = "${pageContext.request.contextPath}";
	$.ajax({
		 
		  type:"GET",
		  url:  "${ctx}/SpringMVCHibernate/ResfulService/ajaxUsingRest",
		  async: false,
		  dataType:"json",
		  contentType: "application/json; charset=utf-8",
		  success : function(data) {
				console.log("SUCCESS: ", data);
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
</html>