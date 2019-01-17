<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
.center {
	width:300px;
	height:340px;
	position: absolute;
	
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	border: 1px solid #eeeeee;
	border-radius: 10px;
	padding: 20px;
}
</style>
</head>
<body>
	<div class="center">
		<form  action="./LoginServlet" method="post">
			<div class="form-group">
				<label for="un">Username:</label> <input type="text"
					class="form-control" id="username" name="username" required>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
			<%
				String login_msg=(String)request.getAttribute("error");  
				if(login_msg!=null)
				{
			%>
			<br/>
			<div class="alert alert-danger">
  				invalid username/password!
			</div>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>