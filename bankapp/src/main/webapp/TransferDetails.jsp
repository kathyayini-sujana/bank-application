<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Details</title>
</head>
<body>
<h3>TRANSFER DETAILS</h3>
<table>
<tr>
<th>Sender AccountNo:</th>
<th>To  AccountNo:</th>
<th>Ammount Transferred</th>
<th>Sender Balance</th>
</tr>
<tr>
<td>${FROMACCOUNTNO}</td> 
<td>${TOACCOUNTNO}</td> 
<td>${AMOUNTTRANSFERRED}</td> 
<td>${SENDERBALANCE}</td>
</tr>
</table>
</body>
</html>