<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Customers</title>
</head>
<body>
<h3>CUSTOMERS LIST AND DETAILS</h3>
<table border="2">
<thead>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>User name</th>
<th>Password</th>
<th>Account Balance</th>
</tr>
</thead>
<tbody>
<c:forEach var="customer" items="${CUSTOMERSLIST}">
<tr>
<td>${customer.id}</td>
<td>${customer.firstName}</td>
<td>${customer.lastName}</td>
<td>${customer.userName}</td>
<td>${customer.password}</td>
<td>${customer.accountBalance}</td>
</tr>
</c:forEach>
</tbody>
</table>




</body>
</html>