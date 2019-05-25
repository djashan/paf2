<%@ page import="models.User" %>
<%@ page import ="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	User user = new User();
	String loginMsg = "please login to continue...";

	if(request.getMethod().equalsIgnoreCase("post"))
	{
		if(user.login(request.getParameter("txtUserName"), request.getParameter("txtPassword")).equals("SUCCESS"))
		{
			request.getRequestDispatcher("/item.jsp").forward(request, response);
		}
		else
		{
			loginMsg = "invalid credentials...";
		}	
	}
%>   


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src = Controllers/jQuery.js></script>
<script type="text/javascript" src = Controllers/controllerMain.js></script>
</head>
<body>

	<from id="formLogin" action="index.jsp" method="post">
		Username <input id="txtUserName" name="txtUserName" type="text"> <br>
		password <input id="txtPassword" name="txtPassword" type="password"><br>
		<input id="btnLogin" name="btnLogin" type="button" value="Login"><br>
		<div id="divStsMsgLogin">
		<% out.println(loginMsg); %>
		</div>
 	
	</from>

</body>
</html>