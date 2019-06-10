<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Librarian</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navadmin.jsp"></jsp:include>
	<div class='container'>
		<table class='table table-bordered table-striped'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Mobile</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="mobile" /></td>
					<td><a href='editlibrarian.jsp'>Edit</a></td>
					<td><a href='deletelibrarian.jsp'>Delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>