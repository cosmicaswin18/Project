<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel='stylesheet' href='bootstrap.min.css' />
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
					<li><a href="index.jsp" class="active">Home</a></li>
					<li><a href="#">Admin</a></li>
					<li><a href="#">Librarian</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class='container'>
		<h3>User Name or password error</h3>
		<h3>Librarian Login</h3>
		<form action="LibrarianLogin" method="post" style="width: 300px">
			<div class="form-group">
				<label for="email1">Email address</label> <input type="email"
					class="form-control" name="email" id="email1" placeholder="Email" />
			</div>
			<div class="form-group">
				<label for="password1">Password</label> <input type="password"
					class="form-control" name="password" id="password1"
					placeholder="Password" />
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>