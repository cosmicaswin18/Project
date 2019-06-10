<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Book Form</title>
<link rel='stylesheet' href='bootstrap.min.css' />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<h3>Issue Book Form</h3>
		<form action="IssueBook" method="post" style="width: 300px">
			<div class="form-group">
				<label for="callno1">Book Callno</label> <input type="text"
					class="form-control" name="callno" id="callno1"
					placeholder="Callno" required="required" />
			</div>
			<div class="form-group">
				<label for="id1">Student Id</label> <input type="text"
					class="form-control" name="studentid" id="id1"
					placeholder="Student Id" required="required" />
			</div>
			<div class="form-group">
				<label for="name1">Student Name</label> <input type="text"
					class="form-control" name="studentname" id="name1"
					placeholder="Student Name" required="required" />
			</div>
			<div class="form-group">
				<label for="mobile1">Student Mobile</label> <input type="number"
					class="form-control" name="studentmobile" id="mobile1"
					placeholder="Student Mobile" required="required" />
			</div>
			<button type="submit" class="btn btn-primary">Issue Book</button>
		</form>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>