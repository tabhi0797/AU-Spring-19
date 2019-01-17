<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
.center {
	width: 300px;
	height: 420px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	border: 1px solid #eeeeee;
	border-radius: 10px;
	padding: 20px;
	position: absolute;
}
</style>
</head>
<body>
	<div class="center">
		<form action="./HomeServlet" method = "post">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" name="usertoken" value="<%=(String)request.getSession().getAttribute("usertoken") %>" disabled>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password" value="<%=(String)request.getSession().getAttribute("password") %>">
			</div>
			<div class="form-group">
				<label for="nickname">Nickname:</label> <input type="text"
					class="form-control" id="nickname" name="nickname" value = "<%=(String)request.getSession().getAttribute("nickname") %>">
			</div>
			<div class="form-group">
				<label for="city">City:</label> <input type="text"
					class="form-control" id="city" name="city" value = "<%=(String)request.getSession().getAttribute("city") %>">
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
</body>
</html>