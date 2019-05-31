<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Success</title>
</head>
<body
	style="text-align: center; color: green; font-size: 20px; margin-top: 200px;">
	User registered successfully. Your Id is
	<s:property value="id" />
	<p>
		Go to <a href="index.jsp">Login</a> Page
	</p>
</body>
</html>