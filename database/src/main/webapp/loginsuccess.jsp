<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset = UTF-8"%>
<html>
<head>
<title>Successful Login</title>
</head>

<body style="background-color: lightyellow;">
	<div style="margin-left: 25%; margin-top: 50px;">
		Welcome,
		<s:property value="#session.user" />
		<br /> <a href="add.jsp"><button>Add Item</button></a><br /> <a
			href="delete.jsp"><button>Delete Item</button></a><br /> <a
			href="display.jsp"><button>Display Item</button></a><br /> <a
			href="edit.jsp"><button>Edit Item</button></a><br />
			<a href="logout">Logout</a>
	</div>
	
</body>
</html>