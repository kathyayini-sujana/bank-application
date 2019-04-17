<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome customer!!</title>
</head>
<body>
<h3>ENTER CUSTOMER DETAILS</h3>
<form action="/customers/save" method="post">
<br>
Enter First Name : <input type="text" name="firstName"/>
<br>
Enter Last Name : <input type="text" name="lastName">
<br>
Enter User Name : <input type="text" name="userName">
<br>
Enter User Password : <input type="password" name="password">
<br>
<input type="submit" value = "create account">
</form>
</body>
</html>