<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Edit Product</title>
</head>
<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Edit Product</h1>
		<s:form action="editaction" method="post">
			<s:textfield label="Product Id" name="pid" required="" />
			<s:textfield label="Product Name" name="pname" required="" />
			<s:textfield label="Product Quantity" name="pqty" required="" />
			<s:textfield label="Product Price" name="pprice" required="" />
			<s:submit value="Edit" />
		</s:form>
	</div>
</body>
</html>