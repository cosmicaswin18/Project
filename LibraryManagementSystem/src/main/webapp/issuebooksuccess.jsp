<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Book Success</title>
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
	<h3>Book issued successfully</h3>
	</div>
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>