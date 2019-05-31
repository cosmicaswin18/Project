<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset = ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login</title>
</head>

<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Login Form</h1>
		<s:form action="loginaction" method="post">
			<s:textfield label="UserName" name="user" required="" />
			<s:textfield label="Password" name="password" type="password"
				required="" />
			<s:submit value="Login" />
		</s:form>
		<p>
			If not registered,then <a href="register.jsp">Register</a> here
		</p>
	</div>
</body>
</html>