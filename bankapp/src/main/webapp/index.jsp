<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome !!</title>
</head>
<body>
<h2> Welcome to the bank</h2>
<h3>login to enter</h3>
<form action="customers/validate" method="post">
<br>
Enter id: <input type="text" name="id"/>
<br>
Enter Password<input type="password" name="password"/>
<br>
<input type="submit" value="login"/>
</form>
</body>
</html>