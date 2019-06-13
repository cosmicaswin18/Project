<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Issued Book</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<table class='table table-bordered table-striped'>
			<tr>
				<th>Callno</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Student Mobile</th>
				<th>Issued Date</th>
				<th>Return Status</th>
				<th>Overdue</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="callno" /></td>
					<td><s:property value="studentid" /></td>
					<td><s:property value="studentname" /></td>
					<td><s:property value="studentmobile" /></td>
					<td><s:property value="issueddate" /></td>
					<td><s:property value="returnstatus" /></td>
					<td><s:property value="overdue" /></td>
					<td><a href='deleteissuebook.jsp'>Delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>