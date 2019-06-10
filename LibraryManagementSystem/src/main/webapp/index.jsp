<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" href="nav.css" />
</head>
<body>

	<jsp:include page="snippets/navhome.jsp"></jsp:include>

	<div class="container-fluid">
		<h1>ELibrarySystem</h1>

		<div class="row">
			<div class="col-md-6">
				<jsp:include page="snippets/adminlogin.jsp"></jsp:include>

			</div>
			<div class="col-md-6">
				<jsp:include page="snippets/librarianlogin.jsp"></jsp:include>
				

			</div>
		</div>
	</div>
	<script src="backNoWork.js" type="text/javascript"></script>
	<jsp:include page="snippets/footer.jsp"></jsp:include>