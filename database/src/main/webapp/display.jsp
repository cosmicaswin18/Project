<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Display Product</title>
</head>
<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Display Product</h1>
		<s:form action="displayaction" method="post">
			<%-- Enter Product Id to display
			<s:textfield label="Product Id" name="pid" required="" />  --%>
			<s:submit  value="Display" />
		</s:form>
	</div>
</body>
</html>