<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
.center {
	width: 300px;
	height: 30px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	padding: 20px;
	position: absolute;
	display: table-cell;
}
</style>
</head>

<body>
	<div class="alert alert-success text-center">
		<strong>Welcome!</strong> your data is stored in Database.
	</div>
	<div class="alert alert-info text-center">
		<form action="./LoginServlet" method="get">
			<button class="btn btn-success" type="submit">Logout</button>
		</form>
	</div>

	<div class="center">
		<p class="text-center" style="padding: 20px">
			Hey
			<%=request.getSession().getAttribute("usertoken")%></p>
	</div>

</body>
</html>