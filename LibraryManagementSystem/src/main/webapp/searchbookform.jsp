<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Book</title>
<link rel='stylesheet' href='bootstrap.min.css' />
<link rel="stylesheet" href="nav.css" />
</head>
<body>
<jsp:include page="snippets/navlibrarian.jsp"></jsp:include>
	<div class='container'>
		<h3>Search Book</h3>
		<form action="SearchBook" method="post" style="width: 300px">
			<div class="form-group">
				<label for="callno1">Callno</label> <input type="text"
					class="form-control" name="callno" id="callno1"
					placeholder="Callno" />
			</div>
			<button type="submit" class="btn btn-primary">Search Book</button>
		</form>
	</div>
	<jsp:include page="snippets/footer.jsp"></jsp:include>