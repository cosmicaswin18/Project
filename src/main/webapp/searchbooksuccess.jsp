<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Book</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<table class='table table-bordered table-striped'>
			<tr>
				<th>Callno</th>
				<th>Name</th>
				<th>Author</th>
				<th>Publisher</th>
				<th>Quantity</th>
				<th>Issued</th>
			
			</tr>
			<s:iterator value="model">
				<tr>
					<td><s:property value="callno" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="author" /></td>
					<td><s:property value="publisher" /></td>
					<td><s:property value="quantity" /></td>
					<td><s:property value="issued" /></td>
					
				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>