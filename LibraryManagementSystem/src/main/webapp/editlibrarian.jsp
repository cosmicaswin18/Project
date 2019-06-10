<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
<body>
	<jsp:include page="snippets/navadmin.jsp"></jsp:include>
	<div class='container'>
		<h3>Edit Librarian</h3>
		<form action="EditLibrarian" method="post" style="width: 300px">
			<div class="form-group">
				<label for="id1">Id</label> <input type="text" class="form-control"
					name="id" id="id1" placeholder="ID" required="required" />
			</div>
			<div class="form-group">
				<label for="name1">Name</label> <input type="text"
					class="form-control" name="name" id="name1" placeholder="Name" required="required" />
			</div>
			<div class="form-group">
				<label for="email1">Email address</label> <input type="email"
					class="form-control" name="email" id="email1" placeholder="Email" required="required" />
			</div>
			<div class="form-group">
				<label for="password1">Password</label> <input type="password"
					class="form-control" name="password" id="password1"
					placeholder="Password" required="required" />
			</div>
			<div class="form-group">
				<label for="mobile1">Mobile Number</label> <input type="number"
					class="form-control" name="mobile" id="mobile1"
					placeholder="Mobile" required="required" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>