<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Delete Product</title>
</head>
<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Delete Product</h1>
		<s:form action="deleteaction" method="post">
			Enter Product Id to delete
			<s:textfield label="Product Id" name="pid" required="" />
			<s:submit value="Delete" />
		</s:form>
	</div>
</body>
</html>