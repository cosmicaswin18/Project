<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Form</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navadmin.jsp"></jsp:include>
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
	<jsp:include page="snippets/footer.jsp"></jsp:include>