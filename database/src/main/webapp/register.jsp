<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Register Form</title>
</head>
<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Register Form</h1>
		<s:form action="registeraction" method="post">
			<s:textfield label="Name" name="name" required="" />
			<s:textfield label="Email" name="email" required="" />
			<s:textfield label="City" name="city" required="" />
			<s:textfield label="UserName" name="uname" required="" />
			<s:textfield label="Password" name="password" type="password"
				required="" />
			<s:submit value="Register" />
		</s:form>
	</div>
</body>
</html>