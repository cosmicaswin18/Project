<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Librarian</title>
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
					<li><a href="addlibrarianform.jsp">Add Librarian</a></li>
					<li><a href="ViewLibrarian">View Librarian</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class='container'>
	<table class='table table-bordered table-striped'>
	<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>
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
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>