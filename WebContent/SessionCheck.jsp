<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP to check session</title>
</head>
<body>
<%
	System.out.println("Inside Session Check.jsp 1 ###################################################################");
	System.out.println("Inside Session Check.jsp 2 ###################################################################");
	if(session.getAttribute("username")!=null){
		%>
		<h1><% out.print("Welcome "+(String)session.getAttribute("username"));%></h1>
		<%
	}
	else{
		%>
		<h1><% out.print("Did not find session attribute. Please login again from index page.");%></h1>
		<%
		//response.sendRedirect("/index.html");
	}
%>
</body>
</html>