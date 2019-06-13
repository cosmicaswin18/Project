<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Book Error</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
	<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<h3>Sorry, unable to issue book.</h3>
		<p>We may have shortage of books or you have not returned books. Kindly visit later.</p>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>