<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel='stylesheet' href='bootstrap.min.css' />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navhome.jsp"></jsp:include>
	<div class='container'>
		<h3>User Name or password error</h3>
		<jsp:include page="snippets/librarianlogin.jsp"></jsp:include>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>