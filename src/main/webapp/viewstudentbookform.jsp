<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student Book</title>
<link rel='stylesheet' href='bootstrap.min.css' />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<h3>View Student Book</h3>
		<form action="ViewStudentBook" method="post" style="width: 300px">
			<div class="form-group">
				<label for="id1">Student Id</label> <input type="text"
					class="form-control" name="studentid" id="id1"
					placeholder="Student Id" />
			</div>
			<button type="submit" class="btn btn-primary">View Student Book</button>
		</form>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>