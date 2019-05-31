<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}

button {
	background-color: #008CBA;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 12px;
}
</style>
</head>
<body style="text-align: center; color: green; font-size: 20px; margin-top: 200px;">
	<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
		<table>
			<thead>
				<tr style="background-color: #E0E0E1;">
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Quantity</th>
					<th>Product Price</th>
				</tr>
			</thead>
			<s:iterator value="list">
				<tr>
					<td><s:property value="pid" /></td>
					<td><s:property value="pname" /></td>
					<td><s:property value="pqty" /></td>
					<td><s:property value="pprice" /></td>
				</tr>
			</s:iterator>
		</table>
		<p>
			Go to <a href="loginsuccess.jsp">Main</a> Page
		</p>
	</div>

</body>
</html>