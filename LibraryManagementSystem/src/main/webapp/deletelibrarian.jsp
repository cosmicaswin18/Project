<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Form</title>
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
		<h3>Delete Librarian</h3>
		<form action="DeleteLibrarian" method="post" style="width: 300px">
			<div class="form-group">
				<label for="id1">Id</label> <input type="text" class="form-control"
					name="id" id="id1" placeholder="ID" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>