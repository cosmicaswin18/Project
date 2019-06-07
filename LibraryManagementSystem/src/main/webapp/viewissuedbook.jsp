<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Issued Book</title>
<link rel="stylesheet" href="bootstrap.min.css" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">ELibrarySystem</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="addbookform.jsp">Add Book</a></li>
					<li><a href="ViewBook">View Book</a></li>
					<li><a href="issuebookform.jsp">Issue Book</a></li>
					<li><a href="ViewIssuedBook">View Issued Book</a></li>
					<li><a href="returnbookform.jsp">Return Book</a></li>
					<li><a href="LogoutLibrarian">Logout</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class='container'>
		<table class='table table-bordered table-striped'>
			<tr>
				<th>Callno</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Student Mobile</th>
				<th>Issued Date</th>
				<th>Return Status</th>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="callno" /></td>
					<td><s:property value="studentid" /></td>
					<td><s:property value="studentname" /></td>
					<td><s:property value="studentmobile" /></td>
					<td><s:property value="issueddate" /></td>
					<td><s:property value="returnstatus" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>