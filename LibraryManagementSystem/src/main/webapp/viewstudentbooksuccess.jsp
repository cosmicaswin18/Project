<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student Book</title>
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
				<th>Student Id</th>
				<th>Return Status</th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="callno" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="studentid" /></td>
					<td><s:property value="returnstatus" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>